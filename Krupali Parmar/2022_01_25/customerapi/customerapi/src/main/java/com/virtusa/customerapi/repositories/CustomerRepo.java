package com.virtusa.customerapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.customerapi.models.Customer;
import com.virtusa.customerapi.models.Bank;
import com.virtusa.customerapi.models.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

	//JPA refers class and fields not table
		@Query("select customer from Customer customer where customer.bank=:bank")
		public List<Customer> findByBank(@Param("bank") Bank bank);
}
