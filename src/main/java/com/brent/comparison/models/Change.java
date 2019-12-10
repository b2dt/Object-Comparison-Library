package com.brent.comparison.models;

import java.util.List;

public class Change {
    private String attributeName;
    private ChangeType changeType;
    private List<CustomAnnotation> annotations;
    private String key;
    private String oldValue;
    private String newValue;

    public List<CustomAnnotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<CustomAnnotation> annotations) {
        this.annotations = annotations;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
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

    public ChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ChangeType changeType) {
        this.changeType = changeType;
    }
}
