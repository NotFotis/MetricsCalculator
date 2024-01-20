package com.example.metricscalculator;

public class TUGResultData {
    private double timeInSeconds;
    private String result;

    public TUGResultData(double timeInSeconds, String result) {
        this.timeInSeconds = timeInSeconds;
        this.result = result;
    }

    public double getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(double timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
