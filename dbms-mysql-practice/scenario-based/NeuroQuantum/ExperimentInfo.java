package com.NeuroQuantum;

public class ExperimentInfo implements Experiment {

    private int experimentId;
    private String experimentTitle;
    private String leadResearcher;
    private double fundingAmount;
    private String complexityLevel;
    private int initiationMonth;
    private int initiationYear;

    public ExperimentInfo(int experimentId, String experimentTitle,
                          String leadResearcher, double fundingAmount,
                          String complexityLevel,
                          int initiationMonth, int initiationYear) {

        this.experimentId = experimentId;
        this.experimentTitle = experimentTitle;
        this.leadResearcher = leadResearcher;
        this.fundingAmount = fundingAmount;
        this.complexityLevel = complexityLevel;
        this.initiationMonth = initiationMonth;
        this.initiationYear = initiationYear;
    }

    public int getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(int experimentId) {
        this.experimentId = experimentId;
    }

    public String getExperimentTitle() {
        return experimentTitle;
    }

    public void setExperimentTitle(String experimentTitle) {
        this.experimentTitle = experimentTitle;
    }

    public String getLeadResearcher() {
        return leadResearcher;
    }

    public void setLeadResearcher(String leadResearcher) {
        this.leadResearcher = leadResearcher;
    }

    @Override
    public double getFundingAmount() {
        return fundingAmount;
    }

    public void setFundingAmount(double fundingAmount) {
        this.fundingAmount = fundingAmount;
    }

    public String getComplexityLevel() {
        return complexityLevel;
    }

    public void setComplexityLevel(String complexityLevel) {
        this.complexityLevel = complexityLevel;
    }

    public int getInitiationMonth() {
        return initiationMonth;
    }

    public void setInitiationMonth(int initiationMonth) {
        this.initiationMonth = initiationMonth;
    }

    public int getInitiationYear() {
        return initiationYear;
    }

    public void setInitiationYear(int initiationYear) {
        this.initiationYear = initiationYear;
    }

    @Override
    public double calculateInnovationScore(int monthsActive) {

        double multiplier;

        switch (complexityLevel) {
            case "QubitOpt":
                multiplier = 1.5;
                break;
            case "Entanglement":
                multiplier = 2.5;
                break;
            case "Cryptography":
                multiplier = 3.5;
                break;
            default:
                multiplier = 1.0;
        }

        return (multiplier * monthsActive * fundingAmount) / 1000;
    }

    @Override
    public double calculateResourceConsumption(int monthsActive) {

        double rate;

        switch (complexityLevel) {
            case "QubitOpt":
                rate = 0.8;
                break;
            case "Entanglement":
                rate = 1.2;
                break;
            case "Cryptography":
                rate = 1.8;
                break;
            default:
                rate = 1.0;
        }

        double result = (monthsActive * rate * fundingAmount) / 100;

        return Math.round(result * 10.0) / 10.0;
    }
}
