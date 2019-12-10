package com.brent.comparison.builders;

import com.brent.comparison.testData.Thigh;

public final class ThighBuilder {
    private Integer size;
    private Double otherSize;

    private ThighBuilder() {
    }

    public static ThighBuilder aThigh() {
        return new ThighBuilder();
    }

    public ThighBuilder withSize(Integer size) {
        this.size = size;
        return this;
    }

    public ThighBuilder withOtherSize(Double otherSize) {
        this.otherSize = otherSize;
        return this;
    }

    public Thigh build() {
        Thigh thigh = new Thigh();
        thigh.setSize(size);
        thigh.setOtherSize(otherSize);
        return thigh;
    }
}
