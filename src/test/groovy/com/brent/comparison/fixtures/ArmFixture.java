package com.brent.comparison.fixtures;

import com.brent.comparison.builders.ArmBuilder;
import com.brent.comparison.testData.RelationToInsured;

import java.util.Arrays;

public class ArmFixture {

    public static ArmBuilder aDefaultArm() {
        return ArmBuilder.anArm()
                .withRelationToInsured(RelationToInsured.APPLICANT)
                .withFingers(Arrays.asList(
                        FingerFixture.aDefaultFinger().withListIndex(1).build(),
                        FingerFixture.aDefaultFinger().withListIndex(2).withFingerLocation("Thumb").build(),
                        FingerFixture.aDefaultFinger().withListIndex(3).withFingerLocation("Middle Finger").build()
                ));
    }
}
