package com.brent.comparison.builders;

import com.brent.comparison.models.Change;
import com.brent.comparison.models.ChangeType;
import com.brent.comparison.models.CustomAnnotation;
import com.brent.comparison.models.FlatChange;

import java.util.ArrayList;
import java.util.List;

public final class FlatChangeBuilder {
    private String attributeName;
    private ChangeType changeType;
    private List<String> parentObjectNames = new ArrayList<>();
    private String parentObjectString;
    private String oldValue;
    private String newValue;
    private List<CustomAnnotation> annotations = new ArrayList<>();

    private FlatChangeBuilder() {
    }

    public static FlatChangeBuilder aFlatChange() {
        return new FlatChangeBuilder();
    }

    public FlatChangeBuilder withChange(Change change) {
        this.attributeName = change.getAttributeName();
        this.changeType = change.getChangeType();
        this.oldValue = change.getOldValue();
        this.newValue = change.getNewValue();
        this.annotations = change.getAnnotations() != null ? change.getAnnotations() : new ArrayList<>();
        return this;
    }

    public FlatChangeBuilder withAttributeName(String attributeName) {
        this.attributeName = attributeName;
        return this;
    }

    public FlatChangeBuilder withParentObjectString(String parentObjectString) {
        this.parentObjectString = parentObjectString;
        return this;
    }

    public FlatChangeBuilder withChangeType(ChangeType changeType) {
        this.changeType = changeType;
        return this;
    }

    public FlatChangeBuilder withParentObjectNames(List<String> parentObjectNames) {
        this.parentObjectNames = parentObjectNames;
        return this;
    }

    public FlatChangeBuilder withOldValue(String oldValue) {
        this.oldValue = oldValue;
        return this;
    }

    public FlatChangeBuilder withNewValue(String newValue) {
        this.newValue = newValue;
        return this;
    }

    public FlatChange build() {
        FlatChange flatChange = new FlatChange();
        flatChange.setAttributeName(attributeName);
        flatChange.setChangeType(changeType);
        flatChange.setParentObjectNames(parentObjectNames);
        flatChange.setOldValue(oldValue);
        flatChange.setNewValue(newValue);
        flatChange.setParentObjectString(parentObjectString);
        flatChange.setAnnotations(annotations);
        return flatChange;
    }
}
