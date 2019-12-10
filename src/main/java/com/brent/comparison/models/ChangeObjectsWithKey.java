package com.brent.comparison.models;

public class ChangeObjectsWithKey {
    private String key;
    private NestedParsedObject oldObject;
    private NestedParsedObject newObject;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public NestedParsedObject getOldObject() {
        return oldObject;
    }

    public void setOldObject(NestedParsedObject oldObject) {
        this.oldObject = oldObject;
    }

    public NestedParsedObject getNewObject() {
        return newObject;
    }

    public void setNewObject(NestedParsedObject newObject) {
        this.newObject = newObject;
    }
}
