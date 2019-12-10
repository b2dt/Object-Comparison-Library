package com.brent.comparison.models;

import com.brent.comparison.services.FlattenService;

import java.util.List;

public class ChangeWrapper {

    private String className; //this.getClassName();
    private String attributeName;
    private List<CustomAnnotation> annotations;
    private String key;
    private List<Change> changes;
    private List<ChangeWrapper> nestedChanges;

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

    public List<Change> getChanges() {
        return changes;
    }

    public void setChanges(List<Change> changes) {
        this.changes = changes;
    }

    public List<ChangeWrapper> getNestedChanges() {
        return nestedChanges;
    }

    public void setNestedChanges(List<ChangeWrapper> nestedChanges) {
        this.nestedChanges = nestedChanges;
    }

    public List<FlatChange> flatten() {
        return FlattenService.flatten(this);
    }
}
