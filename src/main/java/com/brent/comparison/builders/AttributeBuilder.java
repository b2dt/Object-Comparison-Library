package com.brent.comparison.builders;

import com.brent.comparison.models.Attribute;
import com.brent.comparison.models.CustomAnnotation;

import java.util.List;

public final class AttributeBuilder {
    private String attributeName;
    private String key = "";
    private String value;
    private boolean isKey;
    private List<CustomAnnotation> customAnnotations;

    private AttributeBuilder() {
    }

    public static AttributeBuilder anAttribute() {
        return new AttributeBuilder();
    }

    public AttributeBuilder withAttributeName(String attributeName) {
        this.attributeName = attributeName;
        return this;
    }

    public AttributeBuilder withIsKey(boolean isKey) {
        this.isKey = isKey;
        return this;
    }

    public AttributeBuilder withKey(String key) {
        this.key = key;
        return this;
    }

    public AttributeBuilder withValue(String value) {
        this.value = value;
        return this;
    }

    public AttributeBuilder withAnnotations(List<CustomAnnotation> customAnnotations) {
        this.customAnnotations = customAnnotations;
        return this;
    }

    public Attribute build() {
        Attribute attribute = new Attribute();
        attribute.setAttributeName(attributeName);
        attribute.setKey(key);
        attribute.setValue(value);
        attribute.setKey(isKey);
        attribute.setAnnotations(customAnnotations);
        return attribute;
    }
}
