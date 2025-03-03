package com.example.QuizApp.service;

import com.example.QuizApp.dao.QuestionDao;
import com.example.QuizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionDao dao;

    public ResponseEntity<List<Question>> getAllQuestion() {
        try {
            return new ResponseEntity<>(dao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
    }

    public Question getQuestionByCategory(String category) {
        return dao.getQuestionByCategory(category);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            dao.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResponseEntity<>("failure",HttpStatus.BAD_REQUEST);
        }
    }

    public String deleteQuestion(Integer id) {
        dao.deleteById(id);
        return "success";
    }

    public ResponseEntity<String> deleteQuestionWithEntity(Question question) {
        Optional<Question> q = dao.findById(question.getId());
        if (q.isEmpty()) {
            System.out.println("Question not found for id : " + question.getId());
            return new ResponseEntity<>("failure", HttpStatus.BAD_REQUEST);
        } else {
            dao.delete(q.get());
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
    }
}
