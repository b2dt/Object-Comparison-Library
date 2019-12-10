package com.brent.comparison.testData;

public class Thigh {
    @DumbAnnotation(dumbNames = {"CORY", "CORI", "COR-HE", "COR-SHE"})
    private Integer size;
    private Double otherSize;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Double getOtherSize() {
        return otherSize;
    }

    public void setOtherSize(Double otherSize) {
        this.otherSize = otherSize;
    }
}
