package com.brent.comparison.testData;

import com.brent.comparison.annotations.Key;

public class Toe extends PointyThang {
    @Key
    private int listIndex;
    private String toeLocation;

    public String getToeLocation() {
        return toeLocation;
    }

    public void setToeLocation(String toeLocation) {
        this.toeLocation = toeLocation;
    }

    public int getListIndex() {
        return listIndex;
    }

    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }
}
