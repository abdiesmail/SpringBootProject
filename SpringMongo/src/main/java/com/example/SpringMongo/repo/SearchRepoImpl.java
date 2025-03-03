package com.example.SpringMongo.repo;

import com.example.SpringMongo.model.JobPost;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import com.mongodb.client.MongoClient;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.bson.Document;
import com.mongodb.client.AggregateIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

@Component
public class SearchRepoImpl implements SearchRepo{

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Autowired
    Environment env;

    @Override
    public List<JobPost> findByText(String text) {

        final List<JobPost> posts = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase(Objects.requireNonNull(env.getProperty("spring.data.mongodb.database")));
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection
                .aggregate(Arrays.asList(
                        new Document("$search",
                        new Document("text",
                        new Document("query", text)
                                .append("path", Arrays.asList("techs", "profile", "desc")))),
                        new Document("$sort",
                        new Document("exp", 1L)),
                        new Document("$limit", 5L)));
        result.forEach(doc -> posts.add(mongoConverter.read(JobPost.class,doc)));

        return posts;
    }
}
