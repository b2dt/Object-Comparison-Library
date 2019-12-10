package com.brent.comparison.testData;

public abstract class PointyThang {
    private String nailDescription;
    private boolean hasNail;

    public String getNailDescription() {
        return nailDescription;
    }

    public void setNailDescription(String nailDescription) {
        this.nailDescription = nailDescription;
    }

    public boolean isHasNail() {
        return hasNail;
    }

    public void setHasNail(boolean hasNail) {
        this.hasNail = hasNail;
    }
}
