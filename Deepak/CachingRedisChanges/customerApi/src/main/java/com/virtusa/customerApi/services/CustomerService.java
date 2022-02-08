package com.virtusa.customerApi.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.virtusa.customerApi.models.Customer;
import com.virtusa.customerApi.repositories.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	
	public Customer addCustomer(Customer customer) {
		return this.customerRepo.save(customer);
	}
	
	//list all the customers
	@Cacheable(value="Customer")
	public List<Customer> getAllCustomers(){
		return this.customerRepo.findAll();
	}
	
	//list customer by Id
	@Cacheable(value="Customer", key="#customerId")
	public Customer getCustomerById(long customerId) {
		return this.customerRepo.findById(customerId).orElse(null);
	}
	
	//delete
	@CacheEvict(value="Customer", key="#customerId")
	public boolean deleteCustomerById(long customerId) {
		boolean status=false;
		this.customerRepo.deleteById(customerId);
		if(this.getCustomerById(customerId)==null)
			status=true;
		return status;
	}
	
	//update
	@CachePut(value="Customer", key="#customerId")
	public Customer updateCustomer(long customerId, String address){
		
		Customer customer=this.getCustomerById(customerId);
		if(customer!=null)
			customer.setCustomerAddress(address);
		
		return this.customerRepo.save(customer);
		
		
		//return customerList;
		
	}
	
}
