package com.brent.comparison.models;

import java.util.List;

public class Attribute {
    private String attributeName;
    private String key;
    private String value;
    private boolean isKey;
    private List<CustomAnnotation> annotations;

    public List<CustomAnnotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<CustomAnnotation> annotations) {
        this.annotations = annotations;
    }

    public boolean isKey() {
        return isKey;
    }

    public void setKey(boolean key) {
        isKey = key;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
