package com.kyddaniel.QuizAppQuizMicroservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    //@ManyToMany         -> for Entity collection
    @ElementCollection // -> for primitive type collection
    private List<Integer> questionIDs;
}
