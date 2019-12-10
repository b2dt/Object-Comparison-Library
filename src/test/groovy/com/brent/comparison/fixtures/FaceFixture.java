package com.brent.comparison.fixtures;

import com.brent.comparison.builders.FaceBuilder;
import com.brent.comparison.testData.EyeColor;

import java.util.Arrays;

public class FaceFixture {

    public static FaceBuilder aDefaultFace() {
        return FaceBuilder.aFace()
                .withEyes(Arrays.asList(
                        EyeFixture.aDefaultEye().withListIndex(1).build(),
                        EyeFixture.aDefaultEye().withListIndex(2).withEyeColor(EyeColor.GREEN).build()
                ))
                .withHasHair(true)
                .withNoseDescription("Big and pointy");
    }
}
