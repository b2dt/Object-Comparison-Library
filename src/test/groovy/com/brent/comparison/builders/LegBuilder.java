package com.brent.comparison.builders;

import com.brent.comparison.testData.Leg;

public final class LegBuilder {
    private int listIndex;
    private String legDescription;
    private int numInjuries;

    private LegBuilder() {
    }

    public static LegBuilder aLeg() {
        return new LegBuilder();
    }

    public LegBuilder withListIndex(int listIndex) {
        this.listIndex = listIndex;
        return this;
    }

    public LegBuilder withLegDescription(String legDescription) {
        this.legDescription = legDescription;
        return this;
    }

    public LegBuilder withNumInjuries(int numInjuries) {
        this.numInjuries = numInjuries;
        return this;
    }

    public Leg build() {
        Leg leg = new Leg();
        leg.setListIndex(listIndex);
        leg.setLegDescription(legDescription);
        leg.setNumInjuries(numInjuries);
        return leg;
    }
}
