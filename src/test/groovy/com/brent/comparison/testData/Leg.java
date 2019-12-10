package com.brent.comparison.testData;

import com.brent.comparison.annotations.Key;

public class Leg {
    @Key
    @Show(lineIds = {"71", "72", "91"})
    private int listIndex;
    @Show(lineIds = {"71"})
    private String legDescription;
    private boolean isLong;
    private int numInjuries;

    public String getLeg() {
        return legDescription;
    }

    public void setLeg(String leg) {
        this.legDescription = leg;
    }

    public boolean isLong() {
        return isLong;
    }

    public void setLong(boolean aLong) {
        isLong = aLong;
    }

    public int getNumInjuries() {
        return numInjuries;
    }

    public void setNumInjuries(int numInjuries) {
        this.numInjuries = numInjuries;
    }

    public int getListIndex() {
        return listIndex;
    }

    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }

    public String getLegDescription() {
        return legDescription;
    }

    public void setLegDescription(String legDescription) {
        this.legDescription = legDescription;
    }
}
