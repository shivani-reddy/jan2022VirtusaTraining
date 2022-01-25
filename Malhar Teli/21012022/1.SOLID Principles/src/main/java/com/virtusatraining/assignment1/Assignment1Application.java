package com.virtusatraining.assignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment1Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment1Application.class, args);
		SingleResponsibility singleResponsibility = new SingleResponsibility();

		System.out.println(singleResponsibility.getAdd2Double().add2(2.2));
	}

}
