package com.brent.comparison.builders;

import com.brent.comparison.testData.Eye;
import com.brent.comparison.testData.Face;

import java.util.List;

public final class FaceBuilder {
    private String noseDescription;
    private List<Eye> eyes;
    private Boolean hasHair;

    private FaceBuilder() {
    }

    public static FaceBuilder aFace() {
        return new FaceBuilder();
    }

    public FaceBuilder withNoseDescription(String noseDescription) {
        this.noseDescription = noseDescription;
        return this;
    }

    public FaceBuilder withEyes(List<Eye> eyes) {
        this.eyes = eyes;
        return this;
    }

    public FaceBuilder withHasHair(Boolean hasHair) {
        this.hasHair = hasHair;
        return this;
    }

    public Face build() {
        Face face = new Face();
        face.setNoseDescription(noseDescription);
        face.setEyes(eyes);
        face.setHasHair(hasHair);
        return face;
    }
}
