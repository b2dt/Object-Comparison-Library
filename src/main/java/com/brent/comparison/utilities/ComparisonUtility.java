package com.brent.comparison.utilities;

import com.brent.comparison.builders.AssociatedObjectsWithKeyBuilder;
import com.brent.comparison.builders.ChangeObjectsWithKeyBuilder;
import com.brent.comparison.models.AssociatedObjectsWithKey;
import com.brent.comparison.models.ChangeObjectsWithKey;
import com.brent.comparison.models.ChangeWrapper;
import com.brent.comparison.models.NestedParsedObject;

import java.lang.reflect.Field;
import java.util.*;

public class ComparisonUtility {

    public static boolean determineIfStringDifferent(String oldVal, String newVal) {
        if (oldVal == null && newVal == null) {
            return false;
        } else if (oldVal == null || newVal == null) {
            return true;
        } else
            return !oldVal.equals(newVal);
    }

    public static boolean isDirectlyComparable(Field field) {
        return (field.getType().isPrimitive() || String.class.equals(field.getType()) || field.getType().isEnum()) &&
                (!field.getType().isArray() || !field.getType().isInterface() || Collection.class.isAssignableFrom(field.getType()));
    }

    public static boolean isDirectlyComparable(Object obj) {
        return obj == null || ((obj.getClass().isPrimitive() || String.class.equals(obj.getClass()) || obj.getClass().isEnum()) &&
                (!obj.getClass().isArray() || !obj.getClass().isInterface() || Collection.class.isAssignableFrom(obj.getClass())));
    }

    public static boolean isArrayObject(Object obj) {
        return obj.getClass().isArray() || obj.getClass().toString().contains(List.class.getSimpleName());
    }

    public static boolean isMap(Object obj) {
        return Arrays.stream(obj.getClass().getGenericInterfaces()).anyMatch(e -> e.getTypeName().contains(Map.class.getTypeName()));
    }

    public static boolean checkChangeWrapperValidChange(ChangeWrapper changeWrapper) {
        return changeWrapper != null && ((changeWrapper.getChanges() != null && changeWrapper.getChanges().size() > 0) || changeWrapper.getNestedChanges().size() > 0);
    }

    public static List<AssociatedObjectsWithKey> associatedObjectsByKey(Object mapAsObj) {
        Map<Object, Object> objMap = convertToMap(mapAsObj);
        List<AssociatedObjectsWithKey> associatedObjectsWithKeys = new ArrayList<>();
        if (objMap != null) {
            objMap.forEach((key, obj) ->
                    associatedObjectsWithKeys.add(AssociatedObjectsWithKeyBuilder.anAssociatedObjectsWithKey()
                            .withObj(obj)
                            .withKey(key)
                            .build())
            );
        }
        return associatedObjectsWithKeys;
    }

    @SuppressWarnings("unchecked")
    public static Map<Object, Object> convertToMap(Object obj) {
        try {
            return ((Map<Object, Object>) obj);
        } catch (Exception e) {
            throw new RuntimeException("Failed to cast object to Map! " + e.getMessage(), e);
        }
    }

    public static List<ChangeObjectsWithKey> associatedObjectsByKey(Map<String, NestedParsedObject> oldObjMap, Map<String, NestedParsedObject> newObjMap) {
        List<ChangeObjectsWithKey> associatedObjectsWithKeys = new ArrayList<>();
        if (oldObjMap != null) {
            oldObjMap.forEach((key, oldObj) -> {
                        if (newObjMap.containsKey(key)) {
                            associatedObjectsWithKeys.add(ChangeObjectsWithKeyBuilder.aChangeObjectsWithKey()
                                    .withOldObject(oldObj)
                                    .withNewObject(newObjMap.get(key))
                                    .withKey(key)
                                    .build());
                        } else {
                            associatedObjectsWithKeys.add(ChangeObjectsWithKeyBuilder.aChangeObjectsWithKey()
                                    .withOldObject(oldObj)
                                    .withKey(key)
                                    .build());
                        }
                    }
            );
            newObjMap.forEach((key, newObj) -> {
                        if (!oldObjMap.containsKey(key)) {
                            associatedObjectsWithKeys.add(ChangeObjectsWithKeyBuilder.aChangeObjectsWithKey()
                                    .withNewObject(newObj)
                                    .withKey(key)
                                    .build());
                        }
                    }
            );
        } else {
            newObjMap.forEach((key, newObj) ->
                    associatedObjectsWithKeys.add(ChangeObjectsWithKeyBuilder.aChangeObjectsWithKey()
                            .withNewObject(newObj)
                            .withKey(key)
                            .build())
            );
        }
        return associatedObjectsWithKeys;
    }

}
