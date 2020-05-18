package com.brent.comparison.testData.policyDto;

import com.brent.comparison.annotations.CompositeKey;

import java.util.Map;

public class CoverageDTO {
    private Map<String, Object> map;
    @CompositeKey
    private String coverageID;
    @CompositeKey
    private String coverageType;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String getCoverageID() {
        return coverageID;
    }

    public void setCoverageID(String coverageID) {
        this.coverageID = coverageID;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }
}

