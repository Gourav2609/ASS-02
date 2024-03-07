package com.assignment.Dynamic.Quiz.models;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long test_data_id;
    private String question_text;
    private String option_a;
    private String option_b;
    private String option_c;
    private String option_d;
    private String correct_option;
    private Integer next_question_a;
    private Integer next_question_b;
    private Integer next_question_c;
    private Integer next_question_d;
    private String difficulty_level;

    // Constructors, getters, and setters
    // Default constructor
    public Question() {
    }

    // Parameterized constructor
    public Question(String question_text, String option_a, String option_b, String option_c, String option_d, String correct_option, Integer next_question_a, Integer next_question_b, Integer next_question_c, Integer next_question_d, String difficulty_level) {
        this.question_text = question_text;
        this.option_a = option_a;
        this.option_b = option_b;
        this.option_c = option_c;
        this.option_d = option_d;
        this.correct_option = correct_option;
        this.next_question_a = next_question_a;
        this.next_question_b = next_question_b;
        this.next_question_c = next_question_c;
        this.next_question_d = next_question_d;
        this.difficulty_level = difficulty_level;
    }

    // Getter and setters

    public Long getTest_data_id() {
        return test_data_id;
    }

    public void setTest_data_id(Long test_data_id) {
        this.test_data_id = test_data_id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String getOption_a() {
        return option_a;
    }

    public void setOption_a(String option_a) {
        this.option_a = option_a;
    }

    public String getOption_b() {
        return option_b;
    }

    public void setOption_b(String option_b) {
        this.option_b = option_b;
    }

    public String getOption_c() {
        return option_c;
    }

    public void setOption_c(String option_c) {
        this.option_c = option_c;
    }

    public String getOption_d() {
        return option_d;
    }

    public void setOption_d(String option_d) {
        this.option_d = option_d;
    }

    public String getCorrect_option() {
        return correct_option;
    }

    public void setCorrect_option(String correct_option) {
        this.correct_option = correct_option;
    }

    public Integer getNext_question_a() {
        return next_question_a;
    }

    public void setNext_question_a(Integer next_question_a) {
        this.next_question_a = next_question_a;
    }

    public Integer getNext_question_b() {
        return next_question_b;
    }

    public void setNext_question_b(Integer next_question_b) {
        this.next_question_b = next_question_b;
    }

    public Integer getNext_question_c() {
        return next_question_c;
    }

    public void setNext_question_c(Integer next_question_c) {
        this.next_question_c = next_question_c;
    }

    public Integer getNext_question_d() {
        return next_question_d;
    }

    public void setNext_question_d(Integer next_question_d) {
        this.next_question_d = next_question_d;
    }

    public String getDifficulty_level() {
        return difficulty_level;
    }

    public void setDifficulty_level(String difficulty_level) {
        this.difficulty_level = difficulty_level;
    }

    public void setOption(String optionKey, String optionValue) {
        switch (optionKey) {
            case "A":
                this.option_a = optionValue;
                break;
            case "B":
                this.option_b = optionValue;
                break;
            case "C":
                this.option_c = optionValue;
                break;
            case "D":
                this.option_d = optionValue;
                break;
            default:
                // Handle if needed
                break;
        }
    }

    public void setNextQuestion(int i, int numericValue) {
        switch (i) {
            case 0:
                this.next_question_a = numericValue;
                break;
            case 1:
                this.next_question_b = numericValue;
                break;
            case 2:
                this.next_question_c = numericValue;
                break;
            case 3:
                this.next_question_d = numericValue;
                break;
            default:
                // Handle if needed
                break;
        }
    }
}
