package com.brent.comparison.testData.policyDto;

import com.brent.comparison.annotations.CompositeKey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LineOfBusinessDTO {
    private Map<String, Object> map;
    private List<LocationDTO> locationDTOs = new ArrayList<>();
    @CompositeKey
    private String lineOfBusiness;
    @CompositeKey
    private String companyName;

    public String getLineOfBusiness() {
        return lineOfBusiness;
    }

    public void setLineOfBusiness(String lineOfBusiness) {
        this.lineOfBusiness = lineOfBusiness;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<LocationDTO> getLocationDTOs() {
        return locationDTOs;
    }

    public void setLocationDTOs(List<LocationDTO> locationDTOs) {
        this.locationDTOs = locationDTOs;
    }
}
