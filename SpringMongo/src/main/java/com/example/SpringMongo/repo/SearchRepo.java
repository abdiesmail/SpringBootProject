package com.example.SpringMongo.repo;

import com.example.SpringMongo.model.JobPost;

import java.util.List;

public interface SearchRepo {

    List<JobPost> findByText(String text);
}
