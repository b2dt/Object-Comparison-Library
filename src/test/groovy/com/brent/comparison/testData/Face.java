package com.brent.comparison.testData;

import java.util.List;

public class Face {
    private String noseDescription;
    private List<Eye> eyes;
    private Boolean hasHair;

    public String getNoseDescription() {
        return noseDescription;
    }

    public void setNoseDescription(String noseDescription) {
        this.noseDescription = noseDescription;
    }

    public List<Eye> getEyes() {
        return eyes;
    }

    public void setEyes(List<Eye> eyes) {
        this.eyes = eyes;
    }

    public Boolean getHasHair() {
        return hasHair;
    }

    public void setHasHair(Boolean hasHair) {
        this.hasHair = hasHair;
    }
}
