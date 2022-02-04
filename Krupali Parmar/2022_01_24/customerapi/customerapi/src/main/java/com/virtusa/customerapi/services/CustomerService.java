package com.virtusa.customerapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.customerapi.models.Customer;
import com.virtusa.customerapi.repositories.CustomerRepo;
import com.virtusa.customerapi.models.Bank;
import com.virtusa.customerapi.services.BankService;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private BankService bankService;
	
	// CRUD Operations
	
	// Add(Create) customer
	/*	public Customer addCustomer(Customer customer) {
		return this.customerRepo.save(customer);
	}
	*/
	public Customer addCustomer(long bankId,Customer customer) {
		
		 Bank bank=this.bankService.getBankById(bankId);
		 if(bank!=null) 
			 customer.setBank(bank);			
		 
		 else
			 customer.setBank(null);
		 this.customerRepo.save(customer);
		 return customer;
		 
		}
	
	// Get(Retrieve) Customer by Id
	public Customer getCustomerById(long customerId) {
		return this.customerRepo.findById(customerId).orElse(null);
	}
	
	// Get(Retrieve) All Customers
	public List<Customer> getAllCustomers(){
		return this.customerRepo.findAll();
	}
	
	// Update Customer
	public Customer updateCustomer(Customer customer) {
		return this.customerRepo.save(customer);
	}
	
	// Delete Customer
	public boolean deleteCustomerById(long customerId) {
		boolean isDeleted = false;
		this.customerRepo.deleteById(customerId);
		if(this.getCustomerById(customerId)==null)
			isDeleted = true;
		
		return isDeleted;
	}
	
	public List<Customer> updateBank(long bankId) {
		
		Bank bank=this.bankService.getBankById(bankId);
		
		List<Customer> customerList=this.customerRepo.findByBank(bank);
		
	    for(Customer customer:customerList) {
	    	customer.setBank(null);
	    	this.customerRepo.save(customer);
	    }
		
		return customerList;
	}
}
