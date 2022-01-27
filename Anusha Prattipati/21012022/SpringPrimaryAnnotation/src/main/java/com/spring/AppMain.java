package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.pojo.Animal;
import com.spring.pojo.Author;

public class AppMain {

	public static void main(String[] args) {

		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		Author author1 = ac.getBean(Author.class);
		System.out.println(author1);
		
		//Animal obj =(Animal) ac.getBean(Animal.class);
		//System.out.println(obj.getActionName());
		
	}
}