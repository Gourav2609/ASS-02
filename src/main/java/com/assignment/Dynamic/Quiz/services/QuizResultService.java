package com.assignment.Dynamic.Quiz.services;

import com.assignment.Dynamic.Quiz.models.QuizResultEntity;
import com.assignment.Dynamic.Quiz.models.QuizResultRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizResultService {

    private final QuizResultRepository quizResultRepository;

    @Autowired
    public QuizResultService(QuizResultRepository quizResultRepository) {
        this.quizResultRepository = quizResultRepository;
    }

    public void saveQuizResult(QuizResultEntity quizResultEntity) {
        quizResultRepository.save(quizResultEntity);
    }

    public List<QuizResultEntity> getAllQuizResults() {
        return quizResultRepository.findAll();
    }

    // Add other methods as needed
}
