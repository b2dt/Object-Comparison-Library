package com.brent.comparison.services;

import com.brent.comparison.builders.FlatChangeBuilder;
import com.brent.comparison.models.Change;
import com.brent.comparison.models.ChangeWrapper;
import com.brent.comparison.models.ClassNameConstants;
import com.brent.comparison.models.FlatChange;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlattenService {

    public static List<FlatChange> flatten(ChangeWrapper changeWrapper) {
        String firstObjectName = changeWrapper.getClassName().substring(changeWrapper.getClassName().lastIndexOf(".") + 1);
        List<String> firstObject = new ArrayList<>();
        firstObject.add(firstObjectName);
        return flatten(changeWrapper, firstObject);
    }

    private static List<FlatChange> flatten(ChangeWrapper changeWrapper, List<String> attributeTree) {
        List<FlatChange> flatChanges = new ArrayList<>();
        if (changeWrapper.getChanges().size() > 0) {
            for (Change change : changeWrapper.getChanges()) {
                flatChanges.add(
                        FlatChangeBuilder.aFlatChange()
                                .withChange(change)
                                .withAttributeName(change.getAttributeName())
                                .withParentObjectNames(attributeTree)
                                .withParentObjectString(createParentObjectString(attributeTree))
                                .build());
            }
        }
        if (changeWrapper.getNestedChanges().size() > 0) {
            for (ChangeWrapper nestedChangeWrapper : changeWrapper.getNestedChanges()) {
                List<String> newAttributeTree = new LinkedList<>(attributeTree);
                if (ClassNameConstants.isArrayClass(nestedChangeWrapper.getClassName())) {
                    flatChanges.addAll(flattenArray(nestedChangeWrapper, newAttributeTree));
                } else if (nestedChangeWrapper.getClassName().contains(ClassNameConstants.HashSet.getClassNameDefinition())) {
                    flatChanges.addAll(flattenSet(nestedChangeWrapper, newAttributeTree));
                } else {
                    newAttributeTree.add(nestedChangeWrapper.getAttributeName());
                    flatChanges.addAll(flatten(nestedChangeWrapper, newAttributeTree));
                }
            }
        }
        return flatChanges;
    }

    private static List<FlatChange> flattenArray(ChangeWrapper changeWrapper, List<String> attributeTree) {
        return flattenArrayOrSet(changeWrapper, attributeTree, ClassNameConstants.ArrayList);
    }

    private static List<FlatChange> flattenSet(ChangeWrapper changeWrapper, List<String> attributeTree) {
        return flattenArrayOrSet(changeWrapper, attributeTree, ClassNameConstants.HashSet);
    }

    private static List<FlatChange> flattenArrayOrSet(ChangeWrapper changeWrapper, List<String> attributeTree, ClassNameConstants className) {
        List<FlatChange> flatChanges = new ArrayList<>();
        if (changeWrapper.getNestedChanges().size() > 0) {
            for (ChangeWrapper arrayChangeWrapper : changeWrapper.getNestedChanges()) {
                List<String> newAttributeTree = new LinkedList<>(attributeTree);
                if (className.equals(ClassNameConstants.ArrayList))
                    newAttributeTree.add(arrayChangeWrapper.getAttributeName() + "[" + arrayChangeWrapper.getKey() + "]");
                else
                    newAttributeTree.add(arrayChangeWrapper.getAttributeName() + "{" + arrayChangeWrapper.getKey() + "}");
                flatChanges.addAll(flatten(arrayChangeWrapper, newAttributeTree));
            }
        }
        if (changeWrapper.getChanges().size() > 0) {
            for (Change change : changeWrapper.getChanges()) {
                String attributeName = change.getAttributeName().concat(
                        className == ClassNameConstants.ArrayList ? "[" + change.getKey() + "]" : "{" + change.getKey() + "}");
                flatChanges.add(
                        FlatChangeBuilder.aFlatChange()
                                .withChange(change)
                                .withAttributeName(attributeName)
                                .withParentObjectNames(attributeTree)
                                .withParentObjectString(createParentObjectString(attributeTree))
                                .build());
            }
        }
        return flatChanges;
    }

    private static String createParentObjectString(List<String> parentObjectList) {
        return String.join(".", parentObjectList);
    }
}
