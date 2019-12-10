package com.brent.comparison.builders;

import com.brent.comparison.models.ChangeObjectsWithKey;
import com.brent.comparison.models.NestedParsedObject;

public final class ChangeObjectsWithKeyBuilder {
    private String key;
    private NestedParsedObject oldObject;
    private NestedParsedObject newObject;

    private ChangeObjectsWithKeyBuilder() {
    }

    public static ChangeObjectsWithKeyBuilder aChangeObjectsWithKey() {
        return new ChangeObjectsWithKeyBuilder();
    }

    public ChangeObjectsWithKeyBuilder withKey(String key) {
        this.key = key;
        return this;
    }

    public ChangeObjectsWithKeyBuilder withOldObject(NestedParsedObject oldObject) {
        this.oldObject = oldObject;
        return this;
    }

    public ChangeObjectsWithKeyBuilder withNewObject(NestedParsedObject newObject) {
        this.newObject = newObject;
        return this;
    }

    public ChangeObjectsWithKey build() {
        ChangeObjectsWithKey changeObjectsWithKey = new ChangeObjectsWithKey();
        changeObjectsWithKey.setKey(key);
        changeObjectsWithKey.setOldObject(oldObject);
        changeObjectsWithKey.setNewObject(newObject);
        return changeObjectsWithKey;
    }
}
