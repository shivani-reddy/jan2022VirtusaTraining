package com.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import com.spring.pojo.Author;
import com.spring.pojo.Dog;
import com.spring.pojo.Animal;
@Lazy
@Configuration
public class AppConfig {

@Bean
public Animal HelWold() {
		return new Dog();
}

	@Bean
	@Primary
	public Author getAuthor1() {
		System.out.println("getAuthor1() is called");

		Author author = new Author();		
		author.setFullname("Rajesh Kumar");		
		author.setDob("11 December 1982");
		author.setCountry("India");

		return author;
	}

	@Bean
	
	public Author getAuthor2() {
		System.out.println("getAuthor2() is called");

		Author author = new Author();		
		author.setFullname("Kishore Singh");		
		author.setDob("05 May 1991");
		author.setCountry("India");

		return author;
		
	}
}