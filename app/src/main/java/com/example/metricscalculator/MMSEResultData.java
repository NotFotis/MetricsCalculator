package com.example.metricscalculator;

public class MMSEResultData {
    private int orientation;
    private int registration;
    private int attentionAndCalculation;
    private int recall;
    private int language;
    private int results;

    public MMSEResultData(int orientation, int registration, int attentionAndCalculation,
                          int recall, int language, int results) {
        this.orientation = orientation;
        this.registration = registration;
        this.attentionAndCalculation = attentionAndCalculation;
        this.recall = recall;
        this.language = language;
        this.results = results;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getRegistration() {
        return registration;
    }

    public void setRegistration(int registration) {
        this.registration = registration;
    }

    public int getAttentionAndCalculation() {
        return attentionAndCalculation;
    }

    public void setAttentionAndCalculation(int attentionAndCalculation) {
        this.attentionAndCalculation = attentionAndCalculation;
    }

    public int getRecall() {
        return recall;
    }

    public void setRecall(int recall) {
        this.recall = recall;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }
}
