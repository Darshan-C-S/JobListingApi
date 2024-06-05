package com.darshan.jobListing.controller;

import com.darshan.jobListing.model.Post;
import com.darshan.jobListing.repo.PostRepository;
import com.darshan.jobListing.repo.searchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
//import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository repo; //here we are auto-wiring the repo to use the mongo methods

    @Autowired
    searchRepo searchRepo;


    // this method is used to redirect the home url http://localhost:8082/ to the corresponding swagger url

    @RequestMapping(value = "/")
    public void redirect (HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(value = "/posts")   // to get all data
    public List<Post> getAllPosts(){

        return repo.findAll();
    }

    @GetMapping(value = "/posts/{text}")
    public List<Post> searchJob(@PathVariable String text){
        return searchRepo.findByText(text);
    }

    @PostMapping("/post") //to post a new data
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }

    @PutMapping("/update")
    public Post UpdatePost(@RequestBody Post post){
        return repo.save(post);
    }

    @GetMapping("/GetPostprofile/{profile}")
    public List<Post> getPostprofile (@RequestParam String profile){
        return repo.findByProfile(profile);
    }

    @GetMapping("/GetPostprofile/{techs}")
    public List<Post> getPostByTechs(@RequestParam String techs){
        return repo.findByTechs(techs);
    }

//    @GetMapping("/PostProfRes/{}")
//
//    public ResponseEntity<Objects> getprofileResPe(@RequestParam String profile){
//        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
//    }

    /*Indexing is used to make the data search easy and fast in mongoDB but it is initially time-consuming
    * so it's better to note down the necessary fields to index */


/*This is the example of the inter microservice communication where i can use rest endpoint from different
*   controller class or Microservice */

    @GetMapping("/HelloFromPostB")
    public String HelloFromServceB(RestTemplate restTemplate){

        String rs = restTemplate.getForObject("http://localhost:8082/Hellofrom2",String.class);
        return rs;
    }

    @Value("${service.URL}")
    String ServivceURL ;
    @GetMapping("/HelloFromB2")
    public String HelloFromB2 (RestTemplate restTemplate){
        String res = restTemplate.getForObject(ServivceURL , String.class);
        return res;
    }




}
