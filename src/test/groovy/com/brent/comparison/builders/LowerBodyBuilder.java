package com.brent.comparison.builders;

import com.brent.comparison.testData.Feet;
import com.brent.comparison.testData.Leg;
import com.brent.comparison.testData.LowerBody;
import com.brent.comparison.testData.Thigh;

import java.util.List;

public final class LowerBodyBuilder {
    private List<Leg> legs;
    private List<Feet> feet;
    private Thigh thigh;

    private LowerBodyBuilder() {
    }

    public static LowerBodyBuilder aLowerBody() {
        return new LowerBodyBuilder();
    }

    public LowerBodyBuilder withLegs(List<Leg> legs) {
        this.legs = legs;
        return this;
    }

    public LowerBodyBuilder withFeet(List<Feet> feet) {
        this.feet = feet;
        return this;
    }

    public LowerBodyBuilder withThigh(Thigh thigh) {
        this.thigh = thigh;
        return this;
    }

    public LowerBody build() {
        LowerBody lowerBody = new LowerBody();
        lowerBody.setLegs(legs);
        lowerBody.setFeet(feet);
        lowerBody.setThigh(thigh);
        return lowerBody;
    }
}
