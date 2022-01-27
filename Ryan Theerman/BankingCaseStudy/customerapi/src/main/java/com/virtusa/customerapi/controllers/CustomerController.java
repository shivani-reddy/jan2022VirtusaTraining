package com.virtusa.customerapi.controllers;

import com.virtusa.customerapi.models.Customer;
import com.virtusa.customerapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //get
    @GetMapping(value="/",params="version=1.0")
    public List<Customer> getAllCustomers() {
        return this.customerService.getAllCustomers();
    }

    @GetMapping(value="/{customerId}",params = "version=1.0")
    public ResponseEntity<?> getCusomterById(@PathVariable("customerId") long customerId){
        Customer customerObj=this.customerService.getCustomerById(customerId);
        if(customerObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Found");
    }

    //post
    @PostMapping(value = "/{bankId}",params="version=1.0")
    public ResponseEntity<?> addCustomer(@PathVariable("bankId") long bankId, @RequestBody Customer customer) {
        Customer customerObj=this.customerService.addCustomer(bankId,customer);
        if(customerObj!=null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Created");
        }
    }

    //put
    @PutMapping(value="/",params = "version=1.0")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
        Customer customerObj=this.customerService.updateCustomer(customer);
        if(customerObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Created");
    }

    @PutMapping(value="/{bankId}",params = "version=1.0")
    public List<Customer> updateCustomerWithFKNull(@PathVariable("bankId") long bankId){
        return this.customerService.updateBank(bankId);
    }


    //delete
    @DeleteMapping(value="{customerId}",params="version=1.0")
    public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId") long customerId) {
        if(this.customerService.deleteCustomerById(customerId)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Customer with id "+customerId+" deleted");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Found");
        }
    }



}
