package com.brent.comparison.builders;

import com.brent.comparison.models.Change;
import com.brent.comparison.models.ChangeWrapper;
import com.brent.comparison.models.CustomAnnotation;

import java.util.ArrayList;
import java.util.List;

public final class ChangeWrapperBuilder {
    private String className;
    private String attributeName;
    private String key;
    private List<Change> changes = new ArrayList<>();
    private List<ChangeWrapper> nestedChanges = new ArrayList<>();
    private List<CustomAnnotation> annotations;

    private ChangeWrapperBuilder() {
    }

    public static ChangeWrapperBuilder aChangeWrapper() {
        return new ChangeWrapperBuilder();
    }

    public ChangeWrapperBuilder withClassName(String className) {
        this.className = className;
        return this;
    }

    public ChangeWrapperBuilder withAttributeName(String attributeName) {
        this.attributeName = attributeName;
        return this;
    }

    public ChangeWrapperBuilder withChanges(List<Change> changes) {
        this.changes = changes;
        return this;
    }

    public ChangeWrapperBuilder addChange(Change change) {
        this.changes.add(change);
        return this;
    }

    public ChangeWrapperBuilder addAllChangeWrappers(List<ChangeWrapper> changeWrapper) {
        nestedChanges.addAll(changeWrapper);
        return this;
    }

    public ChangeWrapperBuilder withNestedChanges(List<ChangeWrapper> nestedChanges) {
        this.nestedChanges = nestedChanges;
        return this;
    }

    public ChangeWrapperBuilder withANestedChange(ChangeWrapper changeWrapper) {
        this.nestedChanges.add(changeWrapper);
        return this;
    }

    public ChangeWrapperBuilder withKey(String arrayIndex) {
        this.key = arrayIndex;
        return this;
    }

    public ChangeWrapperBuilder withAnnotations(List<CustomAnnotation> annotations) {
        this.annotations = annotations;
        return this;
    }

    public ChangeWrapper build() {
        ChangeWrapper changeWrapper = new ChangeWrapper();
        changeWrapper.setClassName(className);
        changeWrapper.setAttributeName(attributeName);
        changeWrapper.setKey(key);
        changeWrapper.setChanges(changes);
        changeWrapper.setNestedChanges(nestedChanges);
        changeWrapper.setAnnotations(annotations);
        return changeWrapper;
    }
}
