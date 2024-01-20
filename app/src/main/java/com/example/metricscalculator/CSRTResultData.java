package com.example.metricscalculator;

public class CSRTResultData {
    private String gender;
    private int age;
    private double reactionTime;

    public CSRTResultData(String gender, int age, double reactionTime) {
        this.gender = gender;
        this.age = age;
        this.reactionTime = reactionTime;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getReactionTime() {
        return reactionTime;
    }

    public void setReactionTime(double reactionTime) {
        this.reactionTime = reactionTime;
    }
}

