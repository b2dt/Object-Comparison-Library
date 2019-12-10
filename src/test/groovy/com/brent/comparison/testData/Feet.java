package com.brent.comparison.testData;

import com.brent.comparison.annotations.Key;

import java.util.List;

public class Feet {
    @Key
    private int listIndex;
    private List<Toe> toes;
    private boolean isHairy;
    private Integer shoeSize;

    public List<Toe> getToes() {
        return toes;
    }

    public void setToes(List<Toe> toes) {
        this.toes = toes;
    }

    public boolean isHairy() {
        return isHairy;
    }

    public void setHairy(boolean hairy) {
        isHairy = hairy;
    }

    public Integer getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(Integer shoeSize) {
        this.shoeSize = shoeSize;
    }

    public int getListIndex() {
        return listIndex;
    }

    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }
}
