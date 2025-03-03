package com.example.SpringMongo.controller;

import com.example.SpringMongo.model.JobPost;
import com.example.SpringMongo.repo.PostRepo;
import javax.servlet.http.HttpServletResponse;

import com.example.SpringMongo.repo.SearchRepo;
import com.example.SpringMongo.repo.SearchRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    PostRepo repo;

    @Autowired
    SearchRepo searchRepo;


    @RequestMapping("/")
    @ApiIgnore
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<JobPost> findAll(){
        return repo.findAll();
    }

    @PostMapping("/post")
    public JobPost addPost(@RequestBody JobPost post){
        return repo.save(post);
    }

    @GetMapping("/posts/{text}")
    public List<JobPost> findByText(@PathVariable("text") String text){
        return searchRepo.findByText(text);
    }
}
