package com.darshan.jobListing.repo;

import com.darshan.jobListing.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class searchRepoImplimentation implements searchRepo{

    @Autowired
    MongoClient client ;

    @Autowired
    MongoConverter converter;
    @Override
    public List<Post> findByText(String Text) {

        final List<Post> post = new ArrayList<>();
        MongoDatabase database = client.getDatabase("SpringJobListingMongo");
        MongoCollection<Document> collection = database.getCollection("JobListing");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                                new Document("text",
                                new Document("query", Text)
                                        .append("path", Arrays.asList("desc", "techs","profile")))),
                                new Document("$sort",
                                new Document("exp", 1L)),
                                new Document("$limit", 5L)));

        result.forEach(doc -> post.add(converter.read(Post.class , doc)));

        return post;
    }
}
