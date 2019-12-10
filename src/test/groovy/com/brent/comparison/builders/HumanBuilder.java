package com.brent.comparison.builders;

import com.brent.comparison.testData.Human;
import com.brent.comparison.testData.LowerBody;
import com.brent.comparison.testData.Toe;
import com.brent.comparison.testData.UpperBody;

import java.util.List;
import java.util.Map;

public final class HumanBuilder {
    private UpperBody upperBody;
    private LowerBody lowerBody;
    private String gender;
    private Map<String, String> characteristics;
    private Map<String, Toe> testDetails;
    private List<String> nicknames;

    private HumanBuilder() {
    }

    public static HumanBuilder aHuman() {
        return new HumanBuilder();
    }

    public HumanBuilder withUpperBody(UpperBody upperBody) {
        this.upperBody = upperBody;
        return this;
    }

    public HumanBuilder withLowerBody(LowerBody lowerBody) {
        this.lowerBody = lowerBody;
        return this;
    }

    public HumanBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public HumanBuilder withCharacteristics(Map<String, String> characteristics) {
        this.characteristics = characteristics;
        return this;
    }

    public HumanBuilder withTestDetails(Map<String, Toe> testDetails) {
        this.testDetails = testDetails;
        return this;
    }

    public HumanBuilder withNicknames(List<String> nicknames) {
        this.nicknames = nicknames;
        return this;
    }

    public Human build() {
        Human human = new Human();
        human.setUpperBody(upperBody);
        human.setLowerBody(lowerBody);
        human.setGender(gender);
        human.setCharacteristics(characteristics);
        human.setTestDetails(testDetails);
        human.setNicknames(nicknames);
        return human;
    }
}
