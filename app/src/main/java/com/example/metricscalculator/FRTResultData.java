package com.example.metricscalculator;

public class FRTResultData {
    private double distance;
    private String result;

    public FRTResultData(double distance, String result) {
        this.distance = distance;
        this.result = result;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
