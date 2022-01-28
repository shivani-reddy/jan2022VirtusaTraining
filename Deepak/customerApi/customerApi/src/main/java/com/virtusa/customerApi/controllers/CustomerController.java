package com.virtusa.customerApi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;
import com.virtusa.customerApi.models.Customer;
import com.virtusa.customerApi.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	//insert
	@PostMapping(value="/{customerId}",params = "version=1.0")
	public ResponseEntity<?> addCustomer(@PathVariable("customerId") long customerId ,@RequestBody Customer customer) {
		Customer custObj=this.customerService.addCustomer(customer);
		if(custObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(custObj);
		else
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
	}
	
	//get all
	@GetMapping(value="/",params = "version=1.0")
	public List<Customer> getAllCustomers(){
		return this.customerService.getAllCustomers();
	}
	
	//get by id
	@GetMapping(value="/{customerId}", params="version=1.0")
	public ResponseEntity<?> getCustomerById(@PathVariable("customer Id") long customerId){
		Customer customerobj=this.customerService.getCustomerById(customerId);
		if(customerobj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerobj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer not found");
			
	}
	
	//update address
	@PutMapping(value="/{customerId}/{address}",params = "version=1.0")
	public ResponseEntity<?> updateCustomer(@PathVariable("customerId") long customerId,@PathVariable("address") String address){
		Customer customerobj=this.customerService.updateCustomer(customerId,address);
		if(customerobj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerobj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("cuatomer not updated");
	}
	
	//delete by id
	@DeleteMapping(value="/{customerId}", params="version 1.0")
	public ResponseEntity<?> deleteByCustomerId(@PathVariable("customeId") long customerId){
		if(this.customerService.deleteCustomerById(customerId))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("customet with"+customerId+ "is deleted");
		else
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Customer not found");
	}
	
	
	//get
	@GetMapping(value="/filters/{customerId}",params = "version=1.0")
	public ResponseEntity<?> getCustomerByFields(@PathVariable("customerId") long traderId,
			@RequestParam(name = "fields", required = false) String fields){
		
		Map<Object,Object> model=new HashMap<>();
    	
    	Customer customer = this.customerService.getCustomerById(traderId);
    	
    	if(customer!=null)
    	{
    		//fields refers to runtime selection
    		ObjectMapper mapper = Squiggly.init(new ObjectMapper(),fields);  		
			return ResponseEntity.ok(SquigglyUtils.stringify(mapper,customer));

    	}
    	else
    	{
	         model.put("message", "customer not existing");
		        
	         return ResponseEntity.ok(model);
    	}

		
		
	}
}
