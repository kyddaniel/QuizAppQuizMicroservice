package com.kyddaniel.QuizAppQuizMicroservice.dao;

import com.kyddaniel.QuizAppQuizMicroservice.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
