package com.customerApi.cutomer.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.customerApi.customer.models.Customer;
import com.customerApi.customer.models.CustomerInput;
import com.customerApi.customer.services.CustomerService;


@Component
public class CustomerMutationResolver implements GraphQLMutationResolver {
	@Autowired
	private CustomerService customerService;
	
	
	
	public Customer createCustomer(CustomerInput customerInput) {
		return this.customerService.addCustomer(new Customer(0,customerInput.getCustomerName(),customerInput.getAddress(),customerInput.getCountry(),customerInput.getBankdetails()));
	}
	
	public Customer updateCustomer(long customerId,String address) {
		return this.customerService.updateCustomer(customerId, address);
	}


}
