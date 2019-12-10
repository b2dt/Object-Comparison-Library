package com.brent.comparison.models;

import java.util.List;

public class NestedParsedObject {
    private String className;
    private String attributeName;
    private String key;
    private List<Attribute> comparableAttributes;
    private List<NestedParsedObject> nestedParsedObjects;
    private List<CustomAnnotation> annotations;

    public List<CustomAnnotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<CustomAnnotation> annotations) {
        this.annotations = annotations;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public List<Attribute> getComparableAttributes() {
        return comparableAttributes;
    }

    public void setComparableAttributes(List<Attribute> comparableAttributes) {
        this.comparableAttributes = comparableAttributes;
    }

    public List<NestedParsedObject> getNestedParsedObjects() {
        return nestedParsedObjects;
    }

    public void setNestedParsedObjects(List<NestedParsedObject> nestedParsedObjects) {
        this.nestedParsedObjects = nestedParsedObjects;
    }
}
