package com.brent.comparison.testData.policyDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PolicyDTO {
    private String policyID;
    private Map<String, Object> map;
    private List<LineOfBusinessDTO> lineOfBusinessDTOs = new ArrayList<>();
    private String pcInd;
    private String ratingEffectiveDate;
    private String companyName;
    private boolean ratingSuccess;
    private String ratingMessage;
    private String channelCode;
    private String transactionCode;
    private int status;
    private String policyNumber;

    public String getPolicyID() {
        return policyID;
    }

    public void setPolicyID(String policyID) {
        this.policyID = policyID;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<LineOfBusinessDTO> getLineOfBusinessDTOs() {
        return lineOfBusinessDTOs;
    }

    public void setLineOfBusinessDTOs(List<LineOfBusinessDTO> lineOfBusinessDTOs) {
        this.lineOfBusinessDTOs = lineOfBusinessDTOs;
    }

    public String getPcInd() {
        return pcInd;
    }

    public void setPcInd(String pcInd) {
        this.pcInd = pcInd;
    }

    public String getRatingEffectiveDate() {
        return ratingEffectiveDate;
    }

    public void setRatingEffectiveDate(String ratingEffectiveDate) {
        this.ratingEffectiveDate = ratingEffectiveDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isRatingSuccess() {
        return ratingSuccess;
    }

    public void setRatingSuccess(boolean ratingSuccess) {
        this.ratingSuccess = ratingSuccess;
    }

    public String getRatingMessage() {
        return ratingMessage;
    }

    public void setRatingMessage(String ratingMessage) {
        this.ratingMessage = ratingMessage;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
}
