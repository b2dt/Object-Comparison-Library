package com.brent.comparison.fixtures;

import com.brent.comparison.builders.EyeBuilder;
import com.brent.comparison.testData.EyeColor;

public class EyeFixture {

    public static EyeBuilder aDefaultEye() {
        return EyeBuilder.anEye()
                .withEyeColor(EyeColor.BLUE);
    }
}
