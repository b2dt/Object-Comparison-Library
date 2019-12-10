package com.brent.comparison.services;

import com.brent.comparison.annotations.CompositeKey;
import com.brent.comparison.annotations.ExcludeFromCompare;
import com.brent.comparison.annotations.Key;
import com.brent.comparison.builders.AttributeBuilder;
import com.brent.comparison.builders.NestedParsedObjectBuilder;
import com.brent.comparison.models.AssociatedObjectsWithKey;
import com.brent.comparison.models.Attribute;
import com.brent.comparison.models.NestedParsedObject;
import com.brent.comparison.utilities.ComparisonUtility;
import com.brent.comparison.utilities.ModificationUtility;
import com.brent.comparison.utilities.ValueRetrievalUtility;
import com.brent.comparison.utilities.WrapperUtility;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ComparableObjectCreationService {

    public static NestedParsedObject buildOutObject(Object obj) throws Exception {
        String firstObjectName = obj.getClass().toString().substring(obj.getClass().toString().lastIndexOf(".") + 1);
        return buildOutObject(firstObjectName, obj);
    }

    public static NestedParsedObject buildOutObject(String attributeName, Object obj) throws Exception {
        NestedParsedObjectBuilder comparableObject = NestedParsedObjectBuilder.aNestedParsedObject()
                .withAttributeName(attributeName);

        if (obj == null) {
            return null;
        }

        if (ComparisonUtility.isArrayObject(obj)) {
            comparableObject.withClassName(obj.getClass().getCanonicalName());
            List<Object> objArr = obj.getClass().isArray() ? Arrays.asList((Object[]) obj) : (List<Object>) obj;
            for (Object arrObjectEntry : objArr) {
                if (ComparisonUtility.isDirectlyComparable(arrObjectEntry) || WrapperUtility.isWrapperType(arrObjectEntry.getClass())) {
                    AttributeBuilder attribute = AttributeBuilder.anAttribute()
                            .withValue(arrObjectEntry.toString())
                            .withAttributeName(attributeName);
                    comparableObject.addAttribute(attribute.build());
                } else {
                    NestedParsedObject newNestedParsedObject = buildOutObject(attributeName, arrObjectEntry);
                    if (newNestedParsedObject != null) {
                        String arrayIndex = ValueRetrievalUtility.determineKey(arrObjectEntry);
                        newNestedParsedObject.setKey(arrayIndex);
                        comparableObject.addComparableObject(newNestedParsedObject);
                    }
                }
            }
        } else if (ComparisonUtility.isMap(obj)) {
            comparableObject.withClassName(obj.getClass().getCanonicalName());
            List<AssociatedObjectsWithKey> associatedObjectsWithKeys = ComparisonUtility.associatedObjectsByKey(obj);
            for (AssociatedObjectsWithKey associatedObject : associatedObjectsWithKeys) {
                if (!ComparisonUtility.isDirectlyComparable(associatedObject.getObj())) {
                    NestedParsedObject newComparableObj = buildOutObject(associatedObject.getObj());
                    if (newComparableObj != null) {
                        newComparableObj.setKey(associatedObject.getKey().toString());
                        newComparableObj.setAttributeName(attributeName);
                        comparableObject.addComparableObject(newComparableObj);
                    }
                } else {
                    Attribute attribute = AttributeBuilder.anAttribute().withValue(associatedObject.getObj().toString()).withKey(associatedObject.getKey().toString()).build();
                    if (attribute != null) {
                        attribute.setKey(null != associatedObject.getKey() ? associatedObject.getKey().toString() : null);
                        attribute.setAttributeName(attributeName);
                        comparableObject.addAttribute(attribute);
                    }
                }
            }
        } else {
            comparableObject.withClassName(obj.getClass().getTypeName());
            List<Field> fields = getAllFields(obj.getClass());
            ModificationUtility.setFieldsToAccessible(fields);

            for (Field field : fields) {
                if (field.isAnnotationPresent(ExcludeFromCompare.class))
                    continue;

                if (ComparisonUtility.isDirectlyComparable(field) || WrapperUtility.isWrapperType(field.getType())) {
                    Object value = field.get(obj);
                    comparableObject.addAttribute(
                            AttributeBuilder.anAttribute()
                                    .withAttributeName(field.getName())
                                    .withValue(value == null ? null : value.toString())
                                    .withIsKey(field.isAnnotationPresent(Key.class) || field.isAnnotationPresent(CompositeKey.class))
                                    .withAnnotations(ValueRetrievalUtility.deriveAnnotations(field))
                                    .build()
                    );
                } else {
                    Object nestedObj = field.get(obj);
                    if (nestedObj == null) {
                        comparableObject.addComparableObject(NestedParsedObjectBuilder.aNestedParsedObject()
                                .withAttributeName(field.getName())
                                .withClassName(field.getType().getCanonicalName())
                                .build());
                    } else {
                        NestedParsedObject newNestedParsedObject = buildOutObject(field.getName(), field.get(obj));
                        if (newNestedParsedObject != null) {
                            newNestedParsedObject.setAnnotations(ValueRetrievalUtility.deriveAnnotations(field));
                            comparableObject.addComparableObject(newNestedParsedObject);
                        }
                    }
                }
            }
        }
        return comparableObject.build();
    }

    public static List<Field> getAllFields(Class<?> type) {
        List<Field> fields = new LinkedList<>();
        for (Class<?> clazz = type; clazz != null; clazz = clazz.getSuperclass()) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        }
        return fields;
    }
}
