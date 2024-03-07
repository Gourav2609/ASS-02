package com.assignment.Dynamic.Quiz.services;

import com.assignment.Dynamic.Quiz.models.Question;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelReaderService {

    public List<Question> readExcelFile(MultipartFile file) throws InvalidFormatException {
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            List<Question> questions = new ArrayList<>();
            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

            for (Row row : sheet) {
                Question question = new Question();
                question.setQuestion_text(row.getCell(0).getStringCellValue()); // Assuming the question is in the first column

                // Handle numeric cells appropriately for options (assuming options are in columns 1-4)
                for (int i = 1; i <= 4; i++) {
                    Cell optionCell = row.getCell(i);
                    if (optionCell.getCellType() == CellType.NUMERIC) {
                        double numericValue = optionCell.getNumericCellValue();
                        question.setOption(i == 1 ? "A" : i == 2 ? "B" : i == 3 ? "C" : "D", String.valueOf((int) numericValue));
                    } else {
                        question.setOption(i == 1 ? "A" : i == 2 ? "B" : i == 3 ? "C" : "D", optionCell.getStringCellValue());
                    }
                }

                // Handle correct option
                Cell correctOptionCell = row.getCell(5); // Assuming the correct option is in the sixth column
                if (correctOptionCell.getCellType() == CellType.NUMERIC) {
                    double numericValue = correctOptionCell.getNumericCellValue();
                    question.setCorrect_option(String.valueOf((int) numericValue));
                } else {
                    question.setCorrect_option(correctOptionCell.getStringCellValue());
                }

                // Handle numeric cells for next question values (assuming next question values are in columns 6-9)
                for (int i = 6; i <= 9; i++) {
                    Cell nextQuestionCell = row.getCell(i);
                    if (nextQuestionCell.getCellType() == CellType.NUMERIC) {
                        double numericValue = nextQuestionCell.getNumericCellValue();
                        question.setNextQuestion(i - 5, (int) numericValue);
                    } else {
                        // Handle if needed
                    }
                }

                question.setDifficulty_level(row.getCell(10).getStringCellValue()); // Assuming difficulty level is in the eleventh column

                questions.add(question);
            }

            return questions;
        } catch (IOException | EncryptedDocumentException e) {
            throw new RuntimeException("Error reading Excel file", e);
        }
    }
}
