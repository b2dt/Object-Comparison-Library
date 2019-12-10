package com.brent.comparison.testData;

import com.brent.comparison.annotations.Key;

public class Eye {
    @Key
    private int listIndex;

    private EyeColor eyeColor;

    public int getListIndex() {
        return listIndex;
    }

    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }
}
