package com.example.metricscalculator;

public class DigitSpanResultData {

    private String length;
    private String presented;
    private String response;
    private int result;

    public DigitSpanResultData(String length, String presented, String response, int result) {
        this.length = length;
        this.presented = presented;
        this.response = response;
        this.result = result;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getPresented() {
        return presented;
    }

    public void setPresented(String presented) {
        this.presented = presented;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}

