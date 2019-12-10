package com.brent.comparison.models;

import java.util.Map;

public class CustomAnnotation {
    private String annotationName;
    private String annotationClass;
    private Map<String, String> annotationValues;

    public String getAnnotationClass() {
        return annotationClass;
    }

    public void setAnnotationClass(String annotationClass) {
        this.annotationClass = annotationClass;
    }

    public String getAnnotationName() {
        return annotationName;
    }

    public void setAnnotationName(String annotationName) {
        this.annotationName = annotationName;
    }

    public Map<String, String> getAnnotationValues() {
        return annotationValues;
    }

    public void setAnnotationValues(Map<String, String> annotationValues) {
        this.annotationValues = annotationValues;
    }
}
