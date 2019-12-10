package com.brent.comparison.fixtures;

import com.brent.comparison.builders.HumanBuilder;

import java.util.Arrays;

public class HumanFixture {

    public static HumanBuilder aDefaultHuman() {
        return HumanBuilder.aHuman()
                .withCharacteristics(CharacteristicsFixture.aDefaultCharacteristics())
                .withLowerBody(LowerBodyFixture.aDefaultLowerBody().build())
                .withTestDetails(TestDetailsFixture.aDefaultTestDetail())
                .withUpperBody(UpperBodyFixture.aDefaultUpperBody().build())
                .withNicknames(Arrays.asList("Bront", "Dino", "Nerd", "NotNerd"))
                .withGender("Male");
    }
}