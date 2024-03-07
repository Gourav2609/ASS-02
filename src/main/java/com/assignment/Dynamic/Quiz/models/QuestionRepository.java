package com.assignment.Dynamic.Quiz.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    // Add custom query methods if needed
}
