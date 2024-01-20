package com.example.metricscalculator;

public class UserData {
    private int CurrentUserId;
    private String username;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String education;

    public UserData() {
        // Default constructor
    }
    public int getCurrentUserId() {
        return CurrentUserId;
    }

    public void setCurrentUserId(int CurrentUserId) {
        this.CurrentUserId = CurrentUserId;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
