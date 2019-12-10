package com.brent.comparison.fixtures;

import com.brent.comparison.builders.LegBuilder;

public class LegFixture {

    public static LegBuilder aDefaultLeg() {
        return LegBuilder.aLeg()
                .withLegDescription("LONG AND WEIRD")
                .withNumInjuries(3);
    }
}
