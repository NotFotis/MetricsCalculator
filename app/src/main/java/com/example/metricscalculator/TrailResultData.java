package com.example.metricscalculator;

public class TrailResultData {
    private int partA;
    private int partB;
    private int age;
    private String result;

    public TrailResultData(int partA, int partB, int age, String result) {
        this.partA = partA;
        this.partB = partB;
        this.age = age;
        this.result = result;
    }

    public int getPartA() {
        return partA;
    }

    public void setPartA(int partA) {
        this.partA = partA;
    }

    public int getPartB() {
        return partB;
    }

    public void setPartB(int partB) {
        this.partB = partB;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

