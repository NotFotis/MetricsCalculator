package com.example.metricscalculator;

public class SUSResultData {
    private int score;
    private double multipliedScore;
    private String result;

    public SUSResultData(int score, double multipliedScore, String result) {
        this.score = score;
        this.multipliedScore = multipliedScore;
        this.result = result;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getMultipliedScore() {
        return multipliedScore;
    }

    public void setMultipliedScore(double multipliedScore) {
        this.multipliedScore = multipliedScore;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

