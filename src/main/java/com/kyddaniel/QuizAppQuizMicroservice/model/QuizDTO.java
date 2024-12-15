package com.kyddaniel.QuizAppQuizMicroservice.model;

import lombok.Data;

// DTO -> data transfer object
@Data
public class QuizDTO {
    String categoryName;
    Integer numQuestions;
    String title;
}
