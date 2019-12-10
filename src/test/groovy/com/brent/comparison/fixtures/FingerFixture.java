package com.brent.comparison.fixtures;

import com.brent.comparison.builders.FingerBuilder;

public class FingerFixture {

    public static FingerBuilder aDefaultFinger() {
        return FingerBuilder.aFinger()
                .withFingerLocation("Pointer")
                .withHasNail(true)
                .withNailDescription("clean");
    }
}
