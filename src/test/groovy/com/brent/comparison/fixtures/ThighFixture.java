package com.brent.comparison.fixtures;

import com.brent.comparison.builders.ThighBuilder;

public class ThighFixture {
    public static ThighBuilder aDefaultThigh() {
        return ThighBuilder.aThigh()
                .withSize(32)
                .withOtherSize(34.00);
    }
}
