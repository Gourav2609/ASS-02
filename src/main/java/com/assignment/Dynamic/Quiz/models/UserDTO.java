package com.assignment.Dynamic.Quiz.models;

public class UserDTO {
    private Long userId;
    private String username;
    private String email;

    // Constructors, getters, and setters

    public UserDTO(Long userId, String username , String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    // Getters and setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
