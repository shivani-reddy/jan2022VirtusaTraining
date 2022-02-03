package com.customerApi.customer.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.customerApi.customer.models.Customer;
import com.customerApi.customer.services.CustomerService;


@Component
public class CustomerQueryResolver implements GraphQLQueryResolver{
	@Autowired
	private CustomerService customerService;
	
	public List<Customer> findAllCustomers(){
		return this.customerService.getAllCustomers();
	}
	
	public Customer findBank(long customerId) {
	
		return this.customerService.getCustomerById(customerId);
	}

}
