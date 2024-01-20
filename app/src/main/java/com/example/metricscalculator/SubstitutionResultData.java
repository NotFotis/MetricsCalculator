package com.example.metricscalculator;

public class SubstitutionResultData {
    private int correct;
    private double responseTime;

    public SubstitutionResultData(int correct, double responseTime) {
        this.correct = correct;
        this.responseTime = responseTime;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }
}

