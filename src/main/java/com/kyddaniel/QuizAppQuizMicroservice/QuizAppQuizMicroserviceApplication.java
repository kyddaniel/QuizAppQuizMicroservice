package com.kyddaniel.QuizAppQuizMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizAppQuizMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizAppQuizMicroserviceApplication.class, args);
	}

}
