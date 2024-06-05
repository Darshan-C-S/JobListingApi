package com.darshan.jobListing.repo;

import com.darshan.jobListing.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;


public interface searchRepo {
    public List<Post> findByText(String Text);
}
