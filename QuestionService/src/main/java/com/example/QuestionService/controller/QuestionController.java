package com.example.QuestionService.controller;


import com.example.QuestionService.model.Question;
import com.example.QuestionService.model.QuestionWrapper;
import com.example.QuestionService.model.Response;
import com.example.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;

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

    @PostMapping("allQuestions")
    public ResponseEntity<String> addAll(@RequestBody List<Question> questions){
        return questionService.addAllQuestion(questions);
    }

    @PostMapping("deleteQuestion")
    public ResponseEntity<String> getAllQuestion(@RequestBody Question question){
        return questionService.deleteQuestionWithEntity(question);
    }

    @DeleteMapping("deleteQuestion/{id}")
    public String getAllQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categery, @RequestParam int numQ){
        return questionService.getQuestionsForQuiz(categery,numQ);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionsFromId(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.calculateResult(responses);
    }

}
