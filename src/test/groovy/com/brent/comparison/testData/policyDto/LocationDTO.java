package com.brent.comparison.testData.policyDto;

import com.brent.comparison.annotations.Key;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocationDTO {
    private Map<String, Object> map;
    private List<CoverageDTO> coverageDTOs = new ArrayList<CoverageDTO>();
    @Key
    private String state = "";

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<CoverageDTO> getCoverageDTOs() {
        return coverageDTOs;
    }

    public void setCoverageDTOs(List<CoverageDTO> coverageDTOs) {
        this.coverageDTOs = coverageDTOs;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

