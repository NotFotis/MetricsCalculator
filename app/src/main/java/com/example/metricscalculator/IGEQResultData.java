package com.example.metricscalculator;

public class IGEQResultData {

    private double competence;
    private double immersion;
    private double flow;
    private double tension;
    private double challenge;
    private double negative;
    private double positive;

    // Constructors

    public IGEQResultData(double competence, double immersion, double flow, double tension, double challenge, double negative, double positive) {
        this.competence = competence;
        this.immersion = immersion;
        this.flow = flow;
        this.tension = tension;
        this.challenge = challenge;
        this.negative = negative;
        this.positive = positive;
    }

    // Setters

    public void setCompetence(double competence) {
        this.competence = competence;
    }

    public void setImmersion(double immersion) {
        this.immersion = immersion;
    }

    public void setFlow(double flow) {
        this.flow = flow;
    }

    public void setTension(double tension) {
        this.tension = tension;
    }

    public void setChallenge(double challenge) {
        this.challenge = challenge;
    }

    public void setNegative(double negative) {
        this.negative = negative;
    }

    public void setPositive(double positive) {
        this.positive = positive;
    }

    // Getters

    public double getCompetence() {
        return competence;
    }

    public double getImmersion() {
        return immersion;
    }

    public double getFlow() {
        return flow;
    }

    public double getTension() {
        return tension;
    }

    public double getChallenge() {
        return challenge;
    }

    public double getNegative() {
        return negative;
    }

    public double getPositive() {
        return positive;
    }
}

