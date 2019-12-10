package com.brent.comparison.builders;

import com.brent.comparison.testData.Toe;

public final class ToeBuilder {
    private int listIndex;
    private String nailDescription;
    private String toeLocation;
    private boolean hasNail;

    private ToeBuilder() {
    }

    public static ToeBuilder aToe() {
        return new ToeBuilder();
    }

    public ToeBuilder withListIndex(int listIndex) {
        this.listIndex = listIndex;
        return this;
    }

    public ToeBuilder withNailDescription(String nailDescription) {
        this.nailDescription = nailDescription;
        return this;
    }

    public ToeBuilder withToeLocation(String toeLocation) {
        this.toeLocation = toeLocation;
        return this;
    }

    public ToeBuilder withHasNail(boolean hasNail) {
        this.hasNail = hasNail;
        return this;
    }

    public Toe build() {
        Toe toe = new Toe();
        toe.setListIndex(listIndex);
        toe.setNailDescription(nailDescription);
        toe.setToeLocation(toeLocation);
        toe.setHasNail(hasNail);
        return toe;
    }
}
