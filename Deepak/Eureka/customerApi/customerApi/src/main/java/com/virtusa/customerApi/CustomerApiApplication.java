package com.virtusa.customerApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;




@SpringBootApplication
@EnableEurekaClient
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class CustomerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApiApplication.class, args);
	}

}
