package com.assignment.Dynamic.Quiz.models;


import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthResponse {

    private String message;
    private UserDTO user;

    // Constructors, getters, and setters

    // Default constructor
    public AuthResponse() {
    }

    // Parameterized constructor
    public AuthResponse(String message, UserDTO user) {
        this.message = message;
        this.user = user;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String toJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

