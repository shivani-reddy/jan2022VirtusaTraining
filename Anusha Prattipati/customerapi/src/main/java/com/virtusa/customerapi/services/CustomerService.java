package com.virtusa.customerapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.customerapi.models.Customer;
import com.virtusa.customerapi.repositories.CustomerRepo;



@Service
public class CustomerService {
	@Autowired
	private CustomerRepo customerRepo;
	
	//insert 
	
		public Customer addCustomer(Customer customer) {
			return this.customerRepo.save(customer);
		}
		
	//list all customers
		
		
		public List<Customer> getAllCustomers(){
			return this.customerRepo.findAll();
		}
		
		//list customers by Id
		
		public Customer getCustomerById(long customerId) {
			return this.customerRepo.findById(customerId).orElse(null);
		}
		
		//delete

		public boolean deleteCustomerById(long customerId) {
			boolean status=false;
			this.customerRepo.deleteById(customerId);
			if(this.getCustomerById(customerId)==null)
				status=true;
			return status;
		}
		
		//update
		
		public Customer updateCustomer(long customerId,String address) {
			
			Customer customer=this.getCustomerById(customerId);
			if(customer!=null) {
				customer.setAddress(address);
			}
			
			return this.customerRepo.save(customer);
		}
		
}
