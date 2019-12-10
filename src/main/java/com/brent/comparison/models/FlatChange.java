package com.brent.comparison.models;

import java.util.List;

public class FlatChange {

    private List<String> parentObjectNames;
    private String parentObjectString;
    private String attributeName;
    private ChangeType changeType;
    private String oldValue;
    private String newValue;
    private List<CustomAnnotation> annotations;

    public List<CustomAnnotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<CustomAnnotation> annotations) {
        this.annotations = annotations;
    }

    public List<String> getParentObjectNames() {
        return parentObjectNames;
    }

    public String getParentObjectString() {
        return parentObjectString;
    }

    public void setParentObjectString(String parentObjectString) {
        this.parentObjectString = parentObjectString;
    }

    public void setParentObjectNames(List<String> parentObjectNames) {
        this.parentObjectNames = parentObjectNames;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public ChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ChangeType changeType) {
        this.changeType = changeType;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
}
