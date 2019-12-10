package com.brent.comparison.builders;

import com.brent.comparison.testData.Arm;
import com.brent.comparison.testData.Finger;
import com.brent.comparison.testData.RelationToInsured;

import java.util.List;

public final class ArmBuilder {
    private int listIndex;
    private RelationToInsured relationToInsured;
    private List<Finger> fingers;
    private boolean isTan;

    private ArmBuilder() {
    }

    public static ArmBuilder anArm() {
        return new ArmBuilder();
    }

    public ArmBuilder withListIndex(int listIndex) {
        this.listIndex = listIndex;
        return this;
    }

    public ArmBuilder withTan(boolean isTan) {
        this.isTan = isTan;
        return this;
    }

    public ArmBuilder withRelationToInsured(RelationToInsured relationToInsured) {
        this.relationToInsured = relationToInsured;
        return this;
    }

    public ArmBuilder withFingers(List<Finger> fingers) {
        this.fingers = fingers;
        return this;
    }

    public Arm build() {
        Arm arm = new Arm();
        arm.setListIndex(listIndex);
        arm.setRelationToInsured(relationToInsured);
        arm.setFingers(fingers);
        arm.setTan(isTan);
        return arm;
    }
}
