package com.assignment.Dynamic.Quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.assignment.Dynamic.Quiz")
public class DynamicQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicQuizApplication.class, args);
	}

}
