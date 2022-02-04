package com.virtusa.customerApi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.customerApi.models.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

	//@Query("select customer from Customer customer")
	//public List<Customer> findByCustomer(@Param("customer") Customer customer);
}
