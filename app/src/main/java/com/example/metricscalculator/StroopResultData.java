package com.example.metricscalculator;

public class StroopResultData {
    private double congruentTime;
    private double incongruentTime;
    private double stroopEffect;

    public StroopResultData(double congruentTime, double incongruentTime, double stroopEffect) {
        this.congruentTime = congruentTime;
        this.incongruentTime = incongruentTime;
        this.stroopEffect = stroopEffect;
    }

    public double getCongruentTime() {
        return congruentTime;
    }

    public void setCongruentTime(double congruentTime) {
        this.congruentTime = congruentTime;
    }

    public double getIncongruentTime() {
        return incongruentTime;
    }

    public void setIncongruentTime(double incongruentTime) {
        this.incongruentTime = incongruentTime;
    }

    public double getStroopEffect() {
        return stroopEffect;
    }

    public void setStroopEffect(double stroopEffect) {
        this.stroopEffect = stroopEffect;
    }
}
