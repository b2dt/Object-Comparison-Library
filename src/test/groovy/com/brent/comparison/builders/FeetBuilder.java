package com.brent.comparison.builders;

import com.brent.comparison.testData.Feet;
import com.brent.comparison.testData.Toe;

import java.util.List;

public final class FeetBuilder {
    private int listIndex;
    private List<Toe> toes;
    private Integer shoeSize;

    private FeetBuilder() {
    }

    public static FeetBuilder aFeet() {
        return new FeetBuilder();
    }

    public FeetBuilder withListIndex(int listIndex) {
        this.listIndex = listIndex;
        return this;
    }

    public FeetBuilder withToes(List<Toe> toes) {
        this.toes = toes;
        return this;
    }

    public FeetBuilder withShoeSize(Integer shoeSize) {
        this.shoeSize = shoeSize;
        return this;
    }

    public Feet build() {
        Feet feet = new Feet();
        feet.setListIndex(listIndex);
        feet.setToes(toes);
        feet.setShoeSize(shoeSize);
        return feet;
    }
}
