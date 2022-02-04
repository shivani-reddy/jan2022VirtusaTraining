package com.virtusa.customerapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.customerapi.models.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

	//JPA refers class and fields not table
		//@Query("select customer from Customer customer where customer.bank=:bank")
		//public List<Customer> findByBank(@Param("bank") Bank bank);
}
