package com.brent.comparison.fixtures;

import com.brent.comparison.builders.LowerBodyBuilder;

import java.util.Arrays;

public class LowerBodyFixture {

    public static LowerBodyBuilder aDefaultLowerBody() {
        return LowerBodyBuilder.aLowerBody()
                .withLegs(Arrays.asList(
                        LegFixture.aDefaultLeg().withListIndex(1).build(),
                        LegFixture.aDefaultLeg().withListIndex(2).withNumInjuries(10).withLegDescription("good To Go").build()))
                .withFeet(Arrays.asList(
                        FeetFixture.aDefaultFeet().withListIndex(1).build(),
                        FeetFixture.aDefaultFeet().withListIndex(2).withShoeSize(15).build()))
                .withThigh(ThighFixture.aDefaultThigh().build());
    }
}
