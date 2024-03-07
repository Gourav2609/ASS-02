package com.assignment.Dynamic.Quiz.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usertestresult")
public class QuizResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private int totalQuestions;
    private int easyQuestions;
    private int mediumQuestions;
    private int hardQuestions;
    private int score;

    public QuizResultEntity() {
        // Default constructor
    }

    public QuizResultEntity(String username, String email, int totalQuestions, int easyQuestions,
                            int mediumQuestions, int hardQuestions, int score) {
        this.username = username;
        this.email = email;
        this.totalQuestions = totalQuestions;
        this.easyQuestions = easyQuestions;
        this.mediumQuestions = mediumQuestions;
        this.hardQuestions = hardQuestions;
        this.score = score;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getEasyQuestions() {
        return easyQuestions;
    }

    public void setEasyQuestions(int easyQuestions) {
        this.easyQuestions = easyQuestions;
    }

    public int getMediumQuestions() {
        return mediumQuestions;
    }

    public void setMediumQuestions(int mediumQuestions) {
        this.mediumQuestions = mediumQuestions;
    }

    public int getHardQuestions() {
        return hardQuestions;
    }

    public void setHardQuestions(int hardQuestions) {
        this.hardQuestions = hardQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
