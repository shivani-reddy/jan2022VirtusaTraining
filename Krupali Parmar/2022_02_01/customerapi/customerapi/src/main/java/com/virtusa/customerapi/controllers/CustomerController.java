package com.virtusa.customerapi.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.virtusa.customerapi.models.Customer;
import com.virtusa.customerapi.services.CustomerService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RefreshScope
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerService customerService;
	@Value("${newmessage}")
	private String message;
	
    //	Add customers
    @PostMapping(value = "/", params = "version=1.0")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        Customer customerObj = this.customerService.addCustomer(customer);
        if (customerObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer not created");
    }

    //	Get
    @GetMapping(value = "/", params = "version=1.0")
    public List<Customer> getAllCustomers(){
		log.info("message: "+message);
        return this.customerService.getAllCustomers();
    }

    //	Get with Id
    @GetMapping(value = "/{customerId}", params = "version=1.0")
    public ResponseEntity<?> getCustomerById(@PathVariable("customerId") long customerId){
        Customer customerObj = this.customerService.getCustomerById(customerId);
        if (customerObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Costumer not found");
    }

    //	Put
    @PutMapping(value = "/{customerId}", params = "version=1.0")
    public ResponseEntity<?> updateCustomer(@RequestParam("customerId") long customerId, @RequestBody Customer customer){
        Customer customerObj = this.customerService.updateCustomer(customerId, customer);
        if (customerObj != null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer not found");

    }
    //	Delete
    @DeleteMapping(value = "/{customerId}", params = "version=1.0")
    public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") long customerId){
        boolean result = this.customerService.deleteCustomerById(customerId);
        if (result) return ResponseEntity.ok("Successfully Deleted");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bank not deleted/Not Found");
    }
}