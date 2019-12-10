package com.brent.comparison.testData;

import java.util.List;

public class LowerBody {
    private List<Leg> legs;
    private List<Feet> feet;
    private Thigh thigh;

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    public List<Feet> getFeet() {
        return feet;
    }

    public void setFeet(List<Feet> feet) {
        this.feet = feet;
    }

    public Thigh getThigh() {
        return thigh;
    }

    public void setThigh(Thigh thigh) {
        this.thigh = thigh;
    }
}
