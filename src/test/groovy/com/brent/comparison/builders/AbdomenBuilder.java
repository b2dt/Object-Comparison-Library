package com.brent.comparison.builders;

import com.brent.comparison.testData.Abdomen;

public final class AbdomenBuilder {
    private Integer numOfAbs;
    private boolean areDefined;

    private AbdomenBuilder() {
    }

    public static AbdomenBuilder anAbdomen() {
        return new AbdomenBuilder();
    }

    public AbdomenBuilder withNumOfAbs(Integer numOfAbs) {
        this.numOfAbs = numOfAbs;
        return this;
    }

    public AbdomenBuilder withAreDefined(boolean areDefined) {
        this.areDefined = areDefined;
        return this;
    }

    public Abdomen build() {
        Abdomen abdomen = new Abdomen();
        abdomen.setNumOfAbs(numOfAbs);
        abdomen.setAreDefined(areDefined);
        return abdomen;
    }
}
