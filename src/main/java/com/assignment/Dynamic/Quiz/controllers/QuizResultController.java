package com.assignment.Dynamic.Quiz.controllers;

import com.assignment.Dynamic.Quiz.models.QuizResultEntity;
import com.assignment.Dynamic.Quiz.services.QuizResultService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quiz-results")
public class QuizResultController {

    private final QuizResultService quizResultService;

    @Autowired
    public QuizResultController(QuizResultService quizResultService) {
        this.quizResultService = quizResultService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuizResultEntity>> getAllQuizResults() {
        List<QuizResultEntity> quizResults = quizResultService.getAllQuizResults();
        return ResponseEntity.ok(quizResults);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveQuizResult(@RequestBody QuizResultEntity quizResultEntity) {
        quizResultService.saveQuizResult(quizResultEntity);
        return ResponseEntity.ok("Quiz result saved successfully");
    }

    // Add other endpoints as needed

}
