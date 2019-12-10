package com.brent.comparison.testData;

import com.brent.comparison.annotations.Key;

public class Finger extends PointyThang {
    @Key
    private int listIndex;

    private String fingerLocation;

    public int getListIndex() {
        return listIndex;
    }

    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }

    public String getFingerLocation() {
        return fingerLocation;
    }

    public void setFingerLocation(String fingerLocation) {
        this.fingerLocation = fingerLocation;
    }
}
