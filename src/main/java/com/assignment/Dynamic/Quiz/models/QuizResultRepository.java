package com.assignment.Dynamic.Quiz.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizResultRepository extends JpaRepository<QuizResultEntity, Long> {
    
}
