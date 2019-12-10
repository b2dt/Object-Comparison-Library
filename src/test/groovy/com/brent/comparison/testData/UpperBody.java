package com.brent.comparison.testData;

import java.util.List;

public class UpperBody extends PointyThang {
    private List<Arm> arms;
    private Abdomen abs;
    private Chest chest;
    private Boolean isGross;
    private Face face;

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public List<Arm> getArms() {
        return arms;
    }

    public void setArms(List<Arm> arms) {
        this.arms = arms;
    }

    public Abdomen getAbs() {
        return abs;
    }

    public void setAbs(Abdomen abs) {
        this.abs = abs;
    }

    public Chest getChest() {
        return chest;
    }

    public void setChest(Chest chest) {
        this.chest = chest;
    }

    public Boolean getGross() {
        return isGross;
    }

    public void setGross(Boolean gross) {
        isGross = gross;
    }
}
