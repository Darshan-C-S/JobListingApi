package com.darshan.jobListing.model;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "JobListing")
public class Post {
    private String profile;
    private String desc;
    private int exp;
    private String techs[];
}
