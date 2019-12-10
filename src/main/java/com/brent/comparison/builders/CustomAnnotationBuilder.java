package com.brent.comparison.builders;

import com.brent.comparison.models.CustomAnnotation;

import java.util.Map;

public final class CustomAnnotationBuilder {
    private CustomAnnotation customAnnotation;

    private CustomAnnotationBuilder() {
        customAnnotation = new CustomAnnotation();
    }

    public static CustomAnnotationBuilder aCustomAnnotation() {
        return new CustomAnnotationBuilder();
    }

    public CustomAnnotationBuilder withAnnotationName(String annotationName) {
        customAnnotation.setAnnotationName(annotationName);
        return this;
    }

    public CustomAnnotationBuilder withAnnotationClass(String annotationClass) {
        customAnnotation.setAnnotationClass(annotationClass);
        return this;
    }

    public CustomAnnotationBuilder withAnnotationValues(Map<String, String> annotationValues) {
        customAnnotation.setAnnotationValues(annotationValues);
        return this;
    }

    public CustomAnnotation build() {
        return customAnnotation;
    }
}
