package com.ynov.quote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCommentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCommentServiceApplication.class, args);
	}

}
