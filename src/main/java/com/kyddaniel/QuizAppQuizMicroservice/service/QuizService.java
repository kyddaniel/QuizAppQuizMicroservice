package com.kyddaniel.QuizAppQuizMicroservice.service;

import com.kyddaniel.QuizAppQuizMicroservice.dao.QuizDao;
import com.kyddaniel.QuizAppQuizMicroservice.feign.QuizInterface;
import com.kyddaniel.QuizAppQuizMicroservice.model.QuestionWrapper;
import com.kyddaniel.QuizAppQuizMicroservice.model.Quiz;
import com.kyddaniel.QuizAppQuizMicroservice.model.Response;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        // call the "generate" URL from Question Service
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIDs(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {

        Optional<Quiz> quiz = quizDao.findById(id);

        if (quiz.isPresent()) {
            List<Integer> questionsFromDB = quiz.get().getQuestionIDs();
            return quizInterface.getQuestionsFromId(questionsFromDB);
        }
        else {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {

        Optional<Quiz> quiz = quizDao.findById(id);
//        if (quiz.isPresent()) {
//            List<Question> questions = quiz.get().getQuestions();
//            int correct = 0;
//            int i = 0;
//            for (Response response : responses) {
//                if (response.getResponse().equals(questions.get(i).getCorrectAnswer()))
//                    correct++;
//                i++;
//            }
//            return new ResponseEntity<>(correct, HttpStatus.OK);
//        }
//        else {
            return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
//        }
    }
}
