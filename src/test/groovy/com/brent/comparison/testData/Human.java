package com.brent.comparison.testData;

import com.brent.comparison.annotations.ExcludeFromCompare;

import java.util.List;
import java.util.Map;

public class Human {
    @ExcludeFromCompare
    private UpperBody upperBody;
    @Show(lineIds = {"71", "72"})
    private LowerBody lowerBody;
    @Show(lineIds = {"71"})
    private String gender;
    @Show(lineIds = {})
    private Map<String, String> characteristics;
    @Show
    @DumbAnnotation(dumbNames = {"CORY", "CORI", "COR-HE", "COR-SHE"})
    private Map<String, Toe> testDetails;
    private List<String> nicknames;

    public List<String> getNicknames() {
        return nicknames;
    }

    public void setNicknames(List<String> nicknames) {
        this.nicknames = nicknames;
    }

    public Map<String, Toe> getTestDetails() {
        return testDetails;
    }

    public void setTestDetails(Map<String, Toe> testDetails) {
        this.testDetails = testDetails;
    }

    public UpperBody getUpperBody() {
        return upperBody;
    }

    public void setUpperBody(UpperBody upperBody) {
        this.upperBody = upperBody;
    }

    public LowerBody getLowerBody() {
        return lowerBody;
    }

    public void setLowerBody(LowerBody lowerBody) {
        this.lowerBody = lowerBody;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Map<String, String> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Map<String, String> characteristics) {
        this.characteristics = characteristics;
    }
}
