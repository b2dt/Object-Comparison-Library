package com.brent.comparison.fixtures;

import com.brent.comparison.builders.FeetBuilder;

import java.util.Arrays;

public class FeetFixture {

    public static FeetBuilder aDefaultFeet() {
        return FeetBuilder.aFeet()
                .withShoeSize(10)
                .withToes(Arrays.asList(
                        ToeFixture.aDefaultToe().withListIndex(1).build(),
                        ToeFixture.aDefaultToe().withListIndex(2).withToeLocation("Big Toe").build(),
                        ToeFixture.aDefaultToe().withListIndex(3).withToeLocation("Pinky Toe").build()));
    }
}
