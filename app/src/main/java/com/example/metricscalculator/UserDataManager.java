package com.example.metricscalculator;

public class UserDataManager {
    private static UserDataManager instance;
    private static int CurrentUserId;
    private static String username;
    private static String firstName;
    private static String lastName;
    private static String dateOfBirth;
    private static String education;

    private UserDataManager() {
        // Private constructor to prevent instantiation
    }

    public static synchronized UserDataManager getInstance() {
        if (instance == null) {
            instance = new UserDataManager();
        }
        return instance;
    }

    // Getters and setters for user data attributes
    public static int getCurrentUserId() {
        return CurrentUserId;
    }

    public void setCurrentUserId(int CurrentUserId) {
        this.CurrentUserId = CurrentUserId;
    }

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public static String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
