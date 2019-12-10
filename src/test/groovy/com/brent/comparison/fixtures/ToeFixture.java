package com.brent.comparison.fixtures;

import com.brent.comparison.builders.ToeBuilder;

public class ToeFixture {

    public static ToeBuilder aDefaultToe() {
        return ToeBuilder.aToe()
                .withHasNail(false)
                .withNailDescription("Beautiful")
                .withToeLocation("On Foot");
    }
}
