package com.brent.comparison.fixtures;

import com.brent.comparison.builders.UpperBodyBuilder;

import java.util.Arrays;

public class UpperBodyFixture {

    public static UpperBodyBuilder aDefaultUpperBody() {
        return UpperBodyBuilder.anUpperBody()
                .withAbs(AbdomenFixture.aDefaultAbdomen().build())
                .withChest(ChestFixture.aDefaultChest().build())
                .withArms(Arrays.asList(
                        ArmFixture.aDefaultArm().withListIndex(1).withTan(true).build(),
                        ArmFixture.aDefaultArm().withListIndex(2).withTan(true).build()
                ))
                .withFace(FaceFixture.aDefaultFace().build())
                .withHasNail(false)
                .withNailDescription("NOT A NAIL");
    }
}
