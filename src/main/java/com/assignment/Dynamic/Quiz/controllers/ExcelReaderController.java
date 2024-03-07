package com.assignment.Dynamic.Quiz.controllers;

import com.assignment.Dynamic.Quiz.models.Question;
import com.assignment.Dynamic.Quiz.models.QuestionRepository;
import com.assignment.Dynamic.Quiz.services.ExcelReaderService;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ExcelReaderController {

    @Autowired
    private ExcelReaderService excelReaderService;

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/api/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) throws InvalidFormatException, IOException {
        List<Question> questions = excelReaderService.readExcelFile(file);
        questionRepository.saveAll(questions);

        return ResponseEntity.ok("File uploaded successfully");
    }
}
