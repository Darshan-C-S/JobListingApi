package com.darshan.jobListing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;

@SpringBootApplication
//@EnableSwagger2
public class JobListingApplication {
	//configuring the swagger in the application

	private static final Logger logger = LoggerFactory.getLogger(JobListingApplication.class);

//http://localhost:8082/swagger-ui/index.html#/post-controller/getAllPosts

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("API Documentation")
						.version("1.0")
						.description("API documentation for the application")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation()
						.description("SpringDoc Wiki Documentation")
						.url("https://springdoc.org/v2/"));
	}

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
				.group("public")
				.pathsToMatch("/**")
				.build();
	}


	public static void main(String[] args) {
		SpringApplication.run(JobListingApplication.class, args);
		logger.info("Hello World");


	}

}
