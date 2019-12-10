package com.brent.comparison.services;


import com.brent.comparison.builders.ChangeBuilder;
import com.brent.comparison.builders.ChangeWrapperBuilder;
import com.brent.comparison.models.*;
import com.brent.comparison.utilities.ComparisonUtility;

public class ObjectComparisonService {

    public static ChangeWrapper diff(Object oldObj, Object newObj) throws Exception {
        NestedParsedObject oldChangeWrapper = ComparableObjectCreationService.buildOutObject(oldObj);
        NestedParsedObject newChangeWrapper = ComparableObjectCreationService.buildOutObject(newObj);

        return compare(oldChangeWrapper, newChangeWrapper);
    }

    public static ChangeWrapper compare(NestedParsedObject oldObj, NestedParsedObject newObj) {
        if (oldObj == null) {
            return buildOutChangeWrapperAgainstNull(newObj, ChangeType.ADDED);
        } else if (newObj == null) {
            return buildOutChangeWrapperAgainstNull(oldObj, ChangeType.DELETED);
        }

        if (oldObj.getClassName().equals(newObj.getClassName()) && oldObj.getAttributeName().equals(newObj.getAttributeName())) {
            ChangeWrapperBuilder newChangeWrapper = ChangeWrapperBuilder.aChangeWrapper()
                    .withClassName(oldObj.getClassName() != null ? oldObj.getClassName() : newObj.getClassName())
                    .withAttributeName(oldObj.getAttributeName() != null ? oldObj.getAttributeName() : newObj.getAttributeName())
                    .withAnnotations(oldObj.getAnnotations() != null ? oldObj.getAnnotations() : newObj.getAnnotations());

            for (Attribute oldAttribute : oldObj.getComparableAttributes()) {
                for (Attribute newAttribute : newObj.getComparableAttributes()) {
                    if (oldAttribute.getAttributeName().equals(newAttribute.getAttributeName()) && oldAttribute.getKey().equals(newAttribute.getKey())) {
                        if (ComparisonUtility.determineIfStringDifferent(oldAttribute.getValue(), newAttribute.getValue())) {
                            Change newChange = createChange(oldAttribute, newAttribute);
                            if (newChange != null) {
                                newChangeWrapper.addChange(newChange);
                            }
                        }
                    }
                }
            }
            for (NestedParsedObject nestedOldObj : oldObj.getNestedParsedObjects()) {
                for (NestedParsedObject nestedNewObj : newObj.getNestedParsedObjects()) {
                    if (nestedOldObj.getAttributeName().equals(nestedNewObj.getAttributeName())) {
                        if ((nestedOldObj.getKey() == null && nestedNewObj.getKey() == null) || nestedOldObj.getKey().equals(nestedNewObj.getKey())) {
                            ChangeWrapper objectChangeWrapper;
                            if (ClassNameConstants.isArrayClass(nestedOldObj.getClassName())) {
                                objectChangeWrapper = ArrayComparisonService.compareArray(nestedOldObj, nestedNewObj);
                            } else if (nestedOldObj.getClassName().contains(ClassNameConstants.HashSet.getClassNameDefinition())) {
                                objectChangeWrapper = HashSetComparisonService.compareHashSet(nestedOldObj, nestedNewObj);
                            } else {
                                objectChangeWrapper = compare(nestedOldObj, nestedNewObj);
                            }
                            if (objectChangeWrapper != null && (objectChangeWrapper.getChanges().size() > 0 || objectChangeWrapper.getNestedChanges().size() > 0)) {
                                newChangeWrapper.withANestedChange(objectChangeWrapper);
                            }
                        }
                    }
                }
            }
            return newChangeWrapper.build();
        }
        throw new NotSameObjectException("Objects passed into service are not the same type of object. unable to compare.");
    }

    private static ChangeWrapper buildOutChangeWrapperAgainstNull(NestedParsedObject obj, ChangeType changeType) {
        ChangeWrapperBuilder changeWrapper = ChangeWrapperBuilder.aChangeWrapper()
                .withClassName(obj.getClassName())
                .withAttributeName(obj.getAttributeName())
                .withKey(obj.getKey());
        if (obj.getComparableAttributes().size() > 0) {
            if (changeType == ChangeType.ADDED) {
                for (Attribute attribute : obj.getComparableAttributes()) {
                    Change change = createChange(null, attribute);
                    if (!(change.getOldValue() == null && change.getNewValue() == null)) {
                        changeWrapper.addChange(change);
                    }
                }
            } else {
                for (Attribute attribute : obj.getComparableAttributes()) {
                    Change change = createChange(attribute, null);
                    if (!(change.getOldValue() == null && change.getNewValue() == null)) {
                        changeWrapper.addChange(change);
                    }
                }
            }
        }
        if (obj.getNestedParsedObjects().size() > 0) {
            for (NestedParsedObject nestedObj : obj.getNestedParsedObjects()) {
                changeWrapper.withANestedChange(buildOutChangeWrapperAgainstNull(nestedObj, changeType));
            }
        }
        return changeWrapper.build();
    }


    private static Change createChange(Attribute oldAtt, Attribute newAtt) {
        if (oldAtt == null || oldAtt.getValue() == null) {
            if (newAtt == null || newAtt.getValue() == null) {
                return ChangeBuilder.aChange().build();
            } else
                return ChangeBuilder.aChange()
                        .withOldValue(null)
                        .withNewValue(newAtt.getValue())
                        .withChangeType(ChangeType.ADDED)
                        .withAttributeName(newAtt.getAttributeName())
                        .withKey(newAtt.getKey())
                        .withAnnotations(newAtt.getAnnotations())
                        .build();
        } else if (newAtt == null || newAtt.getValue() == null) {
            if (oldAtt.getValue() == null) {
                return ChangeBuilder.aChange().build();
            } else
                return ChangeBuilder.aChange()
                        .withOldValue(oldAtt.getValue())
                        .withNewValue(null)
                        .withChangeType(ChangeType.DELETED)
                        .withAttributeName(oldAtt.getAttributeName())
                        .withKey(oldAtt.getKey())
                        .withAnnotations(oldAtt.getAnnotations())
                        .build();
        } else {
            return ChangeBuilder.aChange().withOldValue(oldAtt.getValue())
                    .withNewValue(newAtt.getValue())
                    .withChangeType(ChangeType.CHANGED)
                    .withAttributeName(oldAtt.getAttributeName())
                    .withKey(oldAtt.getKey())
                    .withAnnotations(oldAtt.getAnnotations())
                    .build();
        }
    }

}
