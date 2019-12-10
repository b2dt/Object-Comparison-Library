package com.brent.comparison.testData;

public enum EyeColor {
    BLUE(1, "coolBlue"),
    GREEN(2, "mehGreen"),
    HAZEL(3, "JustBrown"),
    POOP_BROWN(4, "lol");

    private int index;
    private String description;

    EyeColor(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }
}
