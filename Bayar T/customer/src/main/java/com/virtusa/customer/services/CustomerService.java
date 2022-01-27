package com.virtusa.customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.customer.models.Customer;
import com.virtusa.customer.repositories.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public Customer addCustomer(Customer customer) {
		return this.customerRepo.save(customer);
	}
	
	public List<Customer> getAllCustomers() {
		return this.customerRepo.findAll();
	}
	
	public Customer getCustomerById(long customerId) {
		return this.customerRepo.findById(customerId).orElse(null);
	}
	
	public boolean deleteCustomerById(long customerId) {
		boolean status = false;
		this.customerRepo.deleteById(customerId);
		if(this.getCustomerById(customerId) == null)
			status = true;
		return status;
	}
	
	public Customer updateCustomer(long customerId) {
		Customer customer = this.getCustomerById(customerId);
		if(customer != null) {
			customer.setCustomerId(customerId);
		}
		return this.customerRepo.save(customer);

	}

}
