package com.virtusa.calendarapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class CalendarapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalendarapiApplication.class, args);
	}

}
