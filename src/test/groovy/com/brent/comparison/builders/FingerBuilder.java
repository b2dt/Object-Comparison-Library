package com.brent.comparison.builders;

import com.brent.comparison.testData.Finger;

public final class FingerBuilder {
    private String nailDescription;
    private String fingerLocation;
    private boolean hasNail;
    private int listIndex;

    private FingerBuilder() {
    }

    public static FingerBuilder aFinger() {
        return new FingerBuilder();
    }

    public FingerBuilder withNailDescription(String nailDescription) {
        this.nailDescription = nailDescription;
        return this;
    }

    public FingerBuilder withFingerLocation(String fingerLocation) {
        this.fingerLocation = fingerLocation;
        return this;
    }

    public FingerBuilder withHasNail(boolean hasNail) {
        this.hasNail = hasNail;
        return this;
    }

    public FingerBuilder withListIndex(int listIndex) {
        this.listIndex = listIndex;
        return this;
    }

    public Finger build() {
        Finger finger = new Finger();
        finger.setNailDescription(nailDescription);
        finger.setFingerLocation(fingerLocation);
        finger.setHasNail(hasNail);
        finger.setListIndex(listIndex);
        return finger;
    }
}
