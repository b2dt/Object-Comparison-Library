package com.brent.comparison.utilities;

import com.brent.comparison.annotations.CompositeKey;
import com.brent.comparison.annotations.ExcludeFromCompare;
import com.brent.comparison.annotations.Key;
import com.brent.comparison.builders.CustomAnnotationBuilder;
import com.brent.comparison.models.CustomAnnotation;
import com.brent.comparison.models.NoKeyOnArrayException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class ValueRetrievalUtility {
    public static String determineKey(Object object) {
        List<Field> fields = Arrays.asList(object.getClass().getDeclaredFields());
        ModificationUtility.setFieldsToAccessible(fields);
        String key = fields.stream()
                .filter(field ->
                        (field.isAnnotationPresent(Key.class) || field.isAnnotationPresent(CompositeKey.class)) && !field.isAnnotationPresent(ExcludeFromCompare.class)
                )
                .map(field -> {
                    try {
                        return field.getName() + ":" + field.get(object).toString();
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("No access to fields for unexpected reasons.");
                    } catch (NullPointerException e) {
                        throw new RuntimeException("Key has null value! Key/CompositeKey annotated fields must not be null! " + field + " on object: " + object);
                    }
                }).sorted().collect(Collectors.joining(","));
        if (key.isEmpty()) {
            throw new NoKeyOnArrayException(object.getClass());
        }
        return key;
    }

    public static List<CustomAnnotation> deriveAnnotations(Field field) {
        List<CustomAnnotation> annotations = new ArrayList<>();
        for (Annotation annotation : field.getAnnotations()) {
            annotations.add(
                    CustomAnnotationBuilder.aCustomAnnotation()
                            .withAnnotationName(annotation.annotationType().getSimpleName())
                            .withAnnotationClass(annotation.toString())
                            .withAnnotationValues(deriveAnnotationValues(annotation))
                            .build()
            );
        }
        return annotations;
    }

    /*INFO REGARDING ANNOTATION VALUES
    methods must have no parameters, and cannot throw an exception.
    Also, the return types are restricted to primitives, String, Class, enums, annotations, and arrays of these types, and the default value cannot be null.
     */
    public static Map<String, String> deriveAnnotationValues(Annotation annotation) {
        Map<String, String> annotationValues = new HashMap<>();
        for (Method method : annotation.annotationType().getDeclaredMethods()) {
            Object values = invokeMethod(method, annotation);
            if (ComparisonUtility.isArrayObject(values)) {
                String valueStr = Arrays.stream((String[]) values).map(String::toString).collect(Collectors.joining(","));
                annotationValues.put(method.getName(), valueStr);
            } else {
                annotationValues.put(method.getName(), values.toString());
            }
        }
        return annotationValues;
    }

    public static Object invokeMethod(Method method, Annotation annotation) {
        try {
            return method.invoke(annotation, (Object[]) null);
        } catch (Exception e) {
            return String.format("<<< Couldn't derive values... %s >>>?", e.getMessage());
        }
    }
}
