package com.brent.comparison.testData;

import com.brent.comparison.annotations.CompositeKey;

import java.util.List;

public class Arm {

    @CompositeKey
    private boolean isTan;

    @CompositeKey
    private int listIndex;
    private RelationToInsured relationToInsured;


    private List<Finger> fingers;


    public int getListIndex() {
        return listIndex;
    }

    public RelationToInsured getRelationToInsured() {
        return relationToInsured;
    }

    public void setRelationToInsured(RelationToInsured relationToInsured) {
        this.relationToInsured = relationToInsured;
    }

    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }

    public List<Finger> getFingers() {
        return fingers;
    }

    public void setFingers(List<Finger> fingers) {
        this.fingers = fingers;
    }

    public boolean isTan() {
        return isTan;
    }

    public void setTan(boolean tan) {
        isTan = tan;
    }
}
