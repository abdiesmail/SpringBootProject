package com.example.QuizService.service;

import com.example.QuizService.dao.QuizDao;
import com.example.QuizService.feign.QuestionInterface;
import com.example.QuizService.model.QuestionWrapper;
import com.example.QuizService.model.Quiz;
import com.example.QuizService.model.Response;
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
    QuestionInterface questionInterface;

    public ResponseEntity<String> createQuiz(String categery, int numQ, String title) {
        List<Integer> questionsIds = questionInterface.getQuestionsForQuiz(categery,numQ).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questionsIds);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
        Quiz quiz = quizDao.findById(id).get();
        return questionInterface.getQuestionsFromId(quiz.getQuestionIds());
    }

    public ResponseEntity<Integer> calculateResult(List<Response> responses) {
        return questionInterface.getScore(responses);
    }
}
