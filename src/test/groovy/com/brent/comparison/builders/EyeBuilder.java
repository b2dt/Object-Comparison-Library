package com.brent.comparison.builders;

import com.brent.comparison.testData.Eye;
import com.brent.comparison.testData.EyeColor;

public final class EyeBuilder {
    private int listIndex;
    private EyeColor eyeColor;

    private EyeBuilder() {
    }

    public static EyeBuilder anEye() {
        return new EyeBuilder();
    }

    public EyeBuilder withListIndex(int listIndex) {
        this.listIndex = listIndex;
        return this;
    }

    public EyeBuilder withEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
        return this;
    }

    public Eye build() {
        Eye eye = new Eye();
        eye.setListIndex(listIndex);
        eye.setEyeColor(eyeColor);
        return eye;
    }
}
