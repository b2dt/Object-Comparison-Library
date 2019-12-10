package com.brent.comparison.builders;

import com.brent.comparison.models.AssociatedObjectsWithKey;

public final class AssociatedObjectsWithKeyBuilder {
    private Object key;
    private Object obj;

    private AssociatedObjectsWithKeyBuilder() {
    }

    public static AssociatedObjectsWithKeyBuilder anAssociatedObjectsWithKey() {
        return new AssociatedObjectsWithKeyBuilder();
    }

    public AssociatedObjectsWithKeyBuilder withKey(Object key) {
        this.key = key;
        return this;
    }

    public AssociatedObjectsWithKeyBuilder withObj(Object obj) {
        this.obj = obj;
        return this;
    }


    public AssociatedObjectsWithKey build() {
        AssociatedObjectsWithKey associatedObjectsWithKey = new AssociatedObjectsWithKey();
        associatedObjectsWithKey.setKey(key);
        associatedObjectsWithKey.setObj(obj);
        return associatedObjectsWithKey;
    }
}
