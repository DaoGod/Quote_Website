package com.ynov.quote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringQuotesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringQuotesServiceApplication.class, args);
	}

}