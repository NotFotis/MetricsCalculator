package com.example.metricscalculator;

public class ResultData {
    private int age;
    private int number;
    private String gender;
    private String results;

    public ResultData(int age, int number, String gender, String results) {
        this.age = age;
        this.number = number;
        this.gender = gender;
        this.results = results;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return String.format(" %-4d | %-6d | %-6s | %-20s ", age, number, gender, results);
    }
}
