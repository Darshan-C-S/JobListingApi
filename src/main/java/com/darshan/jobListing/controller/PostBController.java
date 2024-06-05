package com.darshan.jobListing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostBController {
    @GetMapping("/Hellofrom2")
    public String postA(){
        return "Hello World";
    }
}
