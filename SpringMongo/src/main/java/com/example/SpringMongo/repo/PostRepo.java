package com.example.SpringMongo.repo;

import com.example.SpringMongo.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<JobPost,String> {
}
