package com.example.dbservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
	    "com.example.dbservice", // wherever your service + controller live
	    "com.example.dbservice.api" // interface from OpenAPI
	})


@EnableJpaRepositories(basePackages = "com.example.dbservice.repository")
@EntityScan(basePackages = "com.example.dbservice.entity")

public class TransactionServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransactionServiceApplication.class, args);
    }
}
