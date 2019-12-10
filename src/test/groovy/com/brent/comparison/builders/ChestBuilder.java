package com.brent.comparison.builders;

import com.brent.comparison.testData.Chest;

public final class ChestBuilder {
    private Double numOfThings;
    private Boolean runningOutOfAttributes;

    private ChestBuilder() {
    }

    public static ChestBuilder aChest() {
        return new ChestBuilder();
    }

    public ChestBuilder withNumOfThings(Double numOfThings) {
        this.numOfThings = numOfThings;
        return this;
    }

    public ChestBuilder withRunningOutOfAttributes(Boolean runningOutOfAttributes) {
        this.runningOutOfAttributes = runningOutOfAttributes;
        return this;
    }

    public Chest build() {
        Chest chest = new Chest();
        chest.setNumOfThings(numOfThings);
        chest.setRunningOutOfAttributes(runningOutOfAttributes);
        return chest;
    }
}
