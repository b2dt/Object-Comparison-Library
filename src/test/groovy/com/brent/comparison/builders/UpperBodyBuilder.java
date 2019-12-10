package com.brent.comparison.builders;

import com.brent.comparison.testData.*;

import java.util.List;

public final class UpperBodyBuilder {
    private String nailDescription;
    private List<Arm> arms;
    private boolean hasNail;
    private Abdomen abs;
    private Chest chest;
    private Face face;

    private UpperBodyBuilder() {
    }

    public static UpperBodyBuilder anUpperBody() {
        return new UpperBodyBuilder();
    }

    public UpperBodyBuilder withNailDescription(String nailDescription) {
        this.nailDescription = nailDescription;
        return this;
    }

    public UpperBodyBuilder withArms(List<Arm> arms) {
        this.arms = arms;
        return this;
    }

    public UpperBodyBuilder withHasNail(boolean hasNail) {
        this.hasNail = hasNail;
        return this;
    }

    public UpperBodyBuilder withAbs(Abdomen abs) {
        this.abs = abs;
        return this;
    }

    public UpperBodyBuilder withChest(Chest chest) {
        this.chest = chest;
        return this;
    }

    public UpperBodyBuilder withFace(Face face) {
        this.face = face;
        return this;
    }

    public UpperBody build() {
        UpperBody upperBody = new UpperBody();
        upperBody.setNailDescription(nailDescription);
        upperBody.setArms(arms);
        upperBody.setHasNail(hasNail);
        upperBody.setAbs(abs);
        upperBody.setChest(chest);
        upperBody.setFace(face);
        return upperBody;
    }
}
