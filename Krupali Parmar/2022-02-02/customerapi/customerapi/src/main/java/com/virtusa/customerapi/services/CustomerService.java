package com.virtusa.customerapi.services;


import com.virtusa.customerapi.models.Customer;
import com.virtusa.customerapi.repositories.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

	
    //insert
    public Customer addCustomer(Customer customer){
		 
        return this.customerRepo.save(customer);
    }
    //update
    @CachePut(value="Customer", key="#customerId")
    public Customer updateCustomer(long customerId, Customer customer){
        return this.customerRepo.save(customer);
    }

    //List all
	@Cacheable(value="Customer")
    public List<Customer> getAllCustomers(){
        return this.customerRepo.findAll();
    }

	@Cacheable(value="Customer", key="#customerId")
    public Customer getCustomerById(long customerId){
        return this.customerRepo.findById(customerId).orElse(null);
    }

	@CacheEvict(value="Customer", key="#customerId")
    public boolean deleteCustomerById(long customerId){
        this.customerRepo.deleteById(customerId);
        return (this.getCustomerById(customerId)==null);
    }
	
}
