package com.virtusa.springcorelab.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {

	@Bean(name = "customer1")
	public Customer ParameswariCustomer() {
		return new Customer(2323, "Parameswari");
	}
	
	@Bean(name = "customer2")
	public Customer VigneshCustomer() {
		return new Customer(234, "Vignesh");
	}
	
	@Lazy
	@Bean(name = "default")
	@Primary
	public Customer DefaultCustomer() {
		return new Customer();
	}
}
