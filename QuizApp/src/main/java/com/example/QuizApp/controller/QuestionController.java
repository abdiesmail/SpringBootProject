package com.example.QuizApp.controller;

import com.example.QuizApp.service.QuestionService;
import com.example.QuizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("question/{category}")
    public Question getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("question")
    public ResponseEntity<String> add(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PostMapping("deleteQuestion")
    public ResponseEntity<String> getAllQuestion(@RequestBody Question question){
        return questionService.deleteQuestionWithEntity(question);
    }

    @DeleteMapping("deleteQuestion/{id}")
    public String getAllQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }
}
