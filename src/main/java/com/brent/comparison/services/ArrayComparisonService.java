package com.brent.comparison.services;

import com.brent.comparison.builders.ChangeBuilder;
import com.brent.comparison.builders.ChangeWrapperBuilder;
import com.brent.comparison.models.*;
import com.brent.comparison.utilities.ModificationUtility;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayComparisonService {

    static ChangeWrapper compareArray(NestedParsedObject oldArray, NestedParsedObject newArray) {
        ChangeWrapperBuilder changeWrapperBuilder = ChangeWrapperBuilder.aChangeWrapper()
                .withKey(oldArray.getKey())
                .withAttributeName(oldArray.getAttributeName())
                .withAnnotations(oldArray.getAnnotations())
                .withClassName(oldArray.getClassName());
        if (oldArray.getComparableAttributes().size() > 0 || newArray.getComparableAttributes().size() > 0) {
            Map<String, Long> oldObjCounts = oldArray.getComparableAttributes().stream().collect(Collectors.groupingBy(Attribute::getValue, Collectors.counting()));
            Map<String, Long> newObjCounts = newArray.getComparableAttributes().stream().collect(Collectors.groupingBy(Attribute::getValue, Collectors.counting()));
            List<Change> changes = handleComparableAttributes(oldObjCounts, newObjCounts, oldArray.getAttributeName());
            if (changes != null) {
                changeWrapperBuilder.withChanges(changes);
            }
        }
        if (oldArray.getNestedParsedObjects().size() > 0 || newArray.getNestedParsedObjects().size() > 0) {
            List<ChangeWrapper> nestedChanges = ModificationUtility.handleNestedParsedObjects(oldArray.getNestedParsedObjects(), newArray.getNestedParsedObjects(), oldArray.getAttributeName());
            if (nestedChanges != null) {
                changeWrapperBuilder.withNestedChanges(nestedChanges);
            }
        }
        return changeWrapperBuilder.build();
    }

    private static List<Change> handleComparableAttributes(Map<String, Long> oldObjCounts, Map<String, Long> newObjCounts, String attributeName) {
        List<Change> changes = new LinkedList<>();
        oldObjCounts.forEach((key, val) -> {
            if (newObjCounts.get(key) != null) {
                long numInstances = val - newObjCounts.get(key);
                if (numInstances > 0) {
                    for (int i = 0; i < numInstances; i++) {
                        changes.add(ChangeBuilder.aChange()
                                .withAttributeName(attributeName)
                                .withChangeType(ChangeType.DELETED)
                                .withKey(val.toString())
                                .withOldValue(key)
                                .build());
                    }
                }
                if (numInstances < 0) {
                    for (int i = 0; i > numInstances; i--) {
                        changes.add(ChangeBuilder.aChange()
                                .withAttributeName(attributeName)
                                .withChangeType(ChangeType.ADDED)
                                .withKey(val.toString())
                                .withNewValue(key)
                                .build());
                    }
                }
            } else {
                changes.add(ChangeBuilder.aChange()
                        .withAttributeName(attributeName)
                        .withChangeType(ChangeType.DELETED)
                        .withKey(val == null ? null : val.toString())
                        .withOldValue(key)
                        .build());
            }
        });
        newObjCounts.forEach((key, val) -> {
            if (oldObjCounts.get(key) == null) {
                changes.add(ChangeBuilder.aChange()
                        .withAttributeName(attributeName)
                        .withChangeType(ChangeType.ADDED)
                        .withKey(val == null ? null : val.toString())
                        .withNewValue(key)
                        .build());
            }
        });
        return changes.size() > 0 ? changes : null;
    }
}
