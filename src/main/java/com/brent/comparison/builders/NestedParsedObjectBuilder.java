package com.brent.comparison.builders;

import com.brent.comparison.models.Attribute;
import com.brent.comparison.models.CustomAnnotation;
import com.brent.comparison.models.NestedParsedObject;

import java.util.ArrayList;
import java.util.List;

public final class NestedParsedObjectBuilder {
    private String className;
    private String attributeName;
    private String key;
    private List<Attribute> comparableAttributes = new ArrayList<>();
    private List<NestedParsedObject> nestedParsedObjects = new ArrayList<>();
    private List<CustomAnnotation> customAnnotations = new ArrayList<>();

    private NestedParsedObjectBuilder() {
    }

    public static NestedParsedObjectBuilder aNestedParsedObject() {
        return new NestedParsedObjectBuilder();
    }

    public NestedParsedObjectBuilder withClassName(String className) {
        this.className = className;
        return this;
    }

    public NestedParsedObjectBuilder withAttributeName(String attributeName) {
        this.attributeName = attributeName;
        return this;
    }

    public NestedParsedObjectBuilder withKey(String key) {
        this.key = key;
        return this;
    }

    public NestedParsedObjectBuilder addAttribute(Attribute attribute) {
        this.comparableAttributes.add(attribute);
        return this;
    }

    public NestedParsedObjectBuilder withComparableAttributes(List<Attribute> comparableAttributes) {
        this.comparableAttributes = comparableAttributes;
        return this;
    }

    public NestedParsedObjectBuilder withAnnotations(List<CustomAnnotation> customAnnotations) {
        this.customAnnotations = customAnnotations;
        return this;
    }

    public NestedParsedObjectBuilder withComparableObjects(List<NestedParsedObject> nestedParsedObjects) {
        this.nestedParsedObjects = nestedParsedObjects;
        return this;
    }

    public NestedParsedObjectBuilder addComparableObject(NestedParsedObject nestedParsedObjects) {
        this.nestedParsedObjects.add(nestedParsedObjects);
        return this;
    }

    public NestedParsedObject build() {
        NestedParsedObject nestedParsedObject = new NestedParsedObject();
        nestedParsedObject.setClassName(className);
        nestedParsedObject.setAttributeName(attributeName);
        nestedParsedObject.setKey(key);
        nestedParsedObject.setComparableAttributes(comparableAttributes);
        nestedParsedObject.setNestedParsedObjects(nestedParsedObjects);
        nestedParsedObject.setAnnotations(customAnnotations);
        return nestedParsedObject;
    }
}
