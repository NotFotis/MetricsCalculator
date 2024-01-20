package com.example.metricscalculator;

public class BBSMetricData {
    private int sittingToStanding;
    private int standingUnsupported;
    private int sittingUnsupported;
    private int standingToSitting;
    private int transfers;
    private int standingWithEyesClosed;
    private int standingWithFeetTogether;
    private int reachingForwardWithOutstretchedArm;
    private int retrievingObjectFromFloor;
    private int turningToLookBehind;
    private int turning360Degrees;
    private int placingAlternateFootOnStool;
    private int standingWithOneFootInFront;
    private int standingOnOneFoot;
    private int total;

    public BBSMetricData(int sittingToStanding, int standingUnsupported, int sittingUnsupported,
                         int standingToSitting, int transfers, int standingWithEyesClosed,
                         int standingWithFeetTogether, int reachingForwardWithOutstretchedArm,
                         int retrievingObjectFromFloor, int turningToLookBehind,
                         int turning360Degrees, int placingAlternateFootOnStool,
                         int standingWithOneFootInFront, int standingOnOneFoot, int total) {
        this.sittingToStanding = sittingToStanding;
        this.standingUnsupported = standingUnsupported;
        this.sittingUnsupported = sittingUnsupported;
        this.standingToSitting = standingToSitting;
        this.transfers = transfers;
        this.standingWithEyesClosed = standingWithEyesClosed;
        this.standingWithFeetTogether = standingWithFeetTogether;
        this.reachingForwardWithOutstretchedArm = reachingForwardWithOutstretchedArm;
        this.retrievingObjectFromFloor = retrievingObjectFromFloor;
        this.turningToLookBehind = turningToLookBehind;
        this.turning360Degrees = turning360Degrees;
        this.placingAlternateFootOnStool = placingAlternateFootOnStool;
        this.standingWithOneFootInFront = standingWithOneFootInFront;
        this.standingOnOneFoot = standingOnOneFoot;
        this.total = total;
    }

    public int getSittingToStanding() {
        return sittingToStanding;
    }

    public void setSittingToStanding(int sittingToStanding) {
        this.sittingToStanding = sittingToStanding;
    }

    public int getStandingUnsupported() {
        return standingUnsupported;
    }

    public void setStandingUnsupported(int standingUnsupported) {
        this.standingUnsupported = standingUnsupported;
    }

    public int getSittingUnsupported() {
        return sittingUnsupported;
    }

    public void setSittingUnsupported(int sittingUnsupported) {
        this.sittingUnsupported = sittingUnsupported;
    }

    public int getStandingToSitting() {
        return standingToSitting;
    }

    public void setStandingToSitting(int standingToSitting) {
        this.standingToSitting = standingToSitting;
    }

    public int getTransfers() {
        return transfers;
    }

    public void setTransfers(int transfers) {
        this.transfers = transfers;
    }

    public int getStandingWithEyesClosed() {
        return standingWithEyesClosed;
    }

    public void setStandingWithEyesClosed(int standingWithEyesClosed) {
        this.standingWithEyesClosed = standingWithEyesClosed;
    }

    public int getStandingWithFeetTogether() {
        return standingWithFeetTogether;
    }

    public void setStandingWithFeetTogether(int standingWithFeetTogether) {
        this.standingWithFeetTogether = standingWithFeetTogether;
    }

    public int getReachingForwardWithOutstretchedArm() {
        return reachingForwardWithOutstretchedArm;
    }

    public void setReachingForwardWithOutstretchedArm(int reachingForwardWithOutstretchedArm) {
        this.reachingForwardWithOutstretchedArm = reachingForwardWithOutstretchedArm;
    }

    public int getRetrievingObjectFromFloor() {
        return retrievingObjectFromFloor;
    }

    public void setRetrievingObjectFromFloor(int retrievingObjectFromFloor) {
        this.retrievingObjectFromFloor = retrievingObjectFromFloor;
    }

    public int getTurningToLookBehind() {
        return turningToLookBehind;
    }

    public void setTurningToLookBehind(int turningToLookBehind) {
        this.turningToLookBehind = turningToLookBehind;
    }

    public int getTurning360Degrees() {
        return turning360Degrees;
    }

    public void setTurning360Degrees(int turning360Degrees) {
        this.turning360Degrees = turning360Degrees;
    }

    public int getPlacingAlternateFootOnStool() {
        return placingAlternateFootOnStool;
    }

    public void setPlacingAlternateFootOnStool(int placingAlternateFootOnStool) {
        this.placingAlternateFootOnStool = placingAlternateFootOnStool;
    }

    public int getStandingWithOneFootInFront() {
        return standingWithOneFootInFront;
    }

    public void setStandingWithOneFootInFront(int standingWithOneFootInFront) {
        this.standingWithOneFootInFront = standingWithOneFootInFront;
    }

    public int getStandingOnOneFoot() {
        return standingOnOneFoot;
    }

    public void setStandingOnOneFoot(int standingOnOneFoot) {
        this.standingOnOneFoot = standingOnOneFoot;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

