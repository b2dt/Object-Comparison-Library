package com.brent.comparison.utilities;

import com.brent.comparison.models.ChangeObjectsWithKey;
import com.brent.comparison.models.ChangeWrapper;
import com.brent.comparison.models.NestedParsedObject;
import com.brent.comparison.services.ObjectComparisonService;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ModificationUtility {

    public static void setFieldsToAccessible(List<Field> fields) {
        fields.forEach(field -> field.setAccessible(true));
    }

    public static List<ChangeWrapper> handleNestedParsedObjects(List<NestedParsedObject> oldNestedObjs, List<NestedParsedObject> newNestedObjs, String attributeName) {
        List<ChangeObjectsWithKey> changeObjectsWithKeys = ModificationUtility.organizeArrays(oldNestedObjs, newNestedObjs);
        List<ChangeWrapper> newChangeWrappers = ModificationUtility.createWrappersFromAssociatedObjects(changeObjectsWithKeys, attributeName);
        if (newChangeWrappers != null && newChangeWrappers.size() > 0) {
            return newChangeWrappers;
        }
        return null;
    }

    public static List<ChangeObjectsWithKey> organizeArrays(List<NestedParsedObject> oldObjects, List<NestedParsedObject> newObjects) {
        Map<String, NestedParsedObject> oldObjectMap = oldObjects.stream()
                .collect(Collectors.toMap(
                        NestedParsedObject::getKey,
                        o -> o
                        )
                );
        Map<String, NestedParsedObject> newObjectMap = newObjects.stream()
                .collect(Collectors.toMap(
                        NestedParsedObject::getKey,
                        o -> o
                        )
                );
        return ComparisonUtility.associatedObjectsByKey(oldObjectMap, newObjectMap);
    }

    public static List<ChangeWrapper> createWrappersFromAssociatedObjects(List<ChangeObjectsWithKey> associatedObjectsWithKeys, String attributeName) {
        List<ChangeWrapper> newChangeWrappers = new ArrayList<>();
        for (ChangeObjectsWithKey associatedObject : associatedObjectsWithKeys) {
            ChangeWrapper newChangeWrapper = ObjectComparisonService.compare(associatedObject.getOldObject(), associatedObject.getNewObject());
            if (ComparisonUtility.checkChangeWrapperValidChange(newChangeWrapper)) {
                newChangeWrapper.setKey(associatedObject.getKey());
                newChangeWrapper.setAttributeName(attributeName);
                newChangeWrappers.add(newChangeWrapper);
            }
        }
        return newChangeWrappers.size() > 0 ? newChangeWrappers : null;
    }
}
