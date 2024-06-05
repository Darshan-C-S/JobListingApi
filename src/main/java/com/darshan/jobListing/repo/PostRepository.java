package com.darshan.jobListing.repo;

import com.darshan.jobListing.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post , String> {
    @Query("{'profile': ?0}")
    List<Post> findByProfile(String profile);

    @Query("{'techs': ?0}")
    List<Post> findByTechs(String Techs);

}
