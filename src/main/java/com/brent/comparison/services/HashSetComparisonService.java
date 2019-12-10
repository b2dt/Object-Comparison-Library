package com.brent.comparison.services;

import com.brent.comparison.builders.ChangeBuilder;
import com.brent.comparison.builders.ChangeWrapperBuilder;
import com.brent.comparison.models.*;
import com.brent.comparison.utilities.ModificationUtility;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashSetComparisonService {

    public static ChangeWrapper compareHashSet(NestedParsedObject oldSet, NestedParsedObject newSet) {
        ChangeWrapperBuilder changeWrapperBuilder = ChangeWrapperBuilder.aChangeWrapper()
                .withKey(oldSet.getKey())
                .withAttributeName(oldSet.getAttributeName())
                .withAnnotations(oldSet.getAnnotations())
                .withClassName(oldSet.getClassName());
        if (oldSet.getComparableAttributes().size() > 0 || newSet.getComparableAttributes().size() > 0) {
            Map<String, Attribute> oldSetMapped = oldSet.getComparableAttributes().stream().collect(Collectors.toMap(Attribute::getKey, attribute -> attribute));
            Map<String, Attribute> newSetMapped = newSet.getComparableAttributes().stream().collect(Collectors.toMap(Attribute::getKey, attribute -> attribute));
            List<Change> changes = compareAttributes(oldSetMapped, newSetMapped);
            if (changes != null) {
                changeWrapperBuilder.withChanges(changes);
            }
        } else if (oldSet.getNestedParsedObjects().size() > 0 || newSet.getNestedParsedObjects().size() > 0) {
            List<ChangeWrapper> nestedChanges = ModificationUtility.handleNestedParsedObjects(oldSet.getNestedParsedObjects(), newSet.getNestedParsedObjects(), oldSet.getAttributeName());
            if (nestedChanges != null) {
                changeWrapperBuilder.withNestedChanges(nestedChanges);
            }
        }
        return changeWrapperBuilder.build();
    }

    private static List<Change> compareAttributes(Map<String, Attribute> oldSetMapped, Map<String, Attribute> newSetMapped) {
        List<Change> changes = new LinkedList<>();
        oldSetMapped.forEach((key, val) -> {
            Attribute newAtt = newSetMapped.get(key);
            if (newAtt != null) {
                if (!val.getValue().equals(newAtt.getValue())) {
                    changes.add(ChangeBuilder.aChange()
                            .withAttributeName(val.getAttributeName())
                            .withChangeType(ChangeType.CHANGED)
                            .withKey(val.getKey())
                            .withOldValue(val.getValue())
                            .withNewValue(newAtt.getValue())
                            .build());
                }
            } else {
                changes.add(ChangeBuilder.aChange()
                        .withAttributeName(val.getAttributeName())
                        .withChangeType(ChangeType.DELETED)
                        .withKey(val.getKey())
                        .withOldValue(val.getValue())
                        .build());
            }
        });
        newSetMapped.forEach((key, val) -> {
            Attribute newAtt = oldSetMapped.get(key);
            if (newAtt == null) {
                changes.add(ChangeBuilder.aChange()
                        .withAttributeName(val.getAttributeName())
                        .withChangeType(ChangeType.ADDED)
                        .withKey(val.getKey())
                        .withNewValue(val.getValue())
                        .build());
            }
        });
        return changes.size() > 0 ? changes : null;
    }
}
