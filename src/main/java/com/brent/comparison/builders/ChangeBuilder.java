package com.brent.comparison.builders;

import com.brent.comparison.models.Change;
import com.brent.comparison.models.ChangeType;
import com.brent.comparison.models.CustomAnnotation;

import java.util.List;

public final class ChangeBuilder {
    private String attributeName;
    private ChangeType changeType;
    private String key;
    private String oldValue;
    private String newValue;
    private List<CustomAnnotation> annotations;

    private ChangeBuilder() {
    }

    public static ChangeBuilder aChange() {
        return new ChangeBuilder();
    }

    public ChangeBuilder withAttributeName(String attributeName) {
        this.attributeName = attributeName;
        return this;
    }

    public ChangeBuilder withAnnotations(List<CustomAnnotation> annotations) {
        this.annotations = annotations;
        return this;
    }


    public ChangeBuilder withChangeType(ChangeType changeType) {
        this.changeType = changeType;
        return this;
    }

    public ChangeBuilder withKey(String key) {
        this.key = key;
        return this;
    }

    public ChangeBuilder withOldValue(String oldValue) {
        this.oldValue = oldValue;
        return this;
    }

    public ChangeBuilder withNewValue(String newValue) {
        this.newValue = newValue;
        return this;
    }

    public Change build() {
        Change change = new Change();
        change.setAttributeName(attributeName);
        change.setChangeType(changeType);
        change.setKey(key);
        change.setOldValue(oldValue);
        change.setNewValue(newValue);
        change.setAnnotations(annotations);
        return change;
    }
}
