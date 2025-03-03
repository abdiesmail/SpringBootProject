package com.example.QuestionService.service;

import com.example.QuestionService.dao.QuestionDao;
import com.example.QuestionService.model.Question;
import com.example.QuestionService.model.QuestionWrapper;
import com.example.QuestionService.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public ResponseEntity<String> addAllQuestion(List<Question> questions) {
        try {
            dao.saveAll(questions);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResponseEntity<>("failure",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categery, int numQ) {
        return new ResponseEntity<>(dao.getRandomByCategory(categery,numQ),HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
        return new ResponseEntity<>(questionIds.stream().map(id -> {
            Question q = dao.findById(id).get();
            return new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
        }).collect(Collectors.toList()),HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(List<Response> responses) {
        return new ResponseEntity<>(
                (int) responses.stream()
                        .filter(res -> dao.findById(res.getId()).get().getRightAnswer().equals(res.getReponse()))
                        .count(),HttpStatus.OK);
    }
}
