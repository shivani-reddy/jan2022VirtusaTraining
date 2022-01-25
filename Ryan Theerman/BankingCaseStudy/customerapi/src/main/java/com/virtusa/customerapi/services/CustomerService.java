package com.virtusa.customerapi.services;

import com.virtusa.customerapi.models.Customer;
import com.virtusa.customerapi.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    //insert
    public Customer addCustomer(Customer customer) {
        return this.customerRepo.save(customer);
    }

    //list all the customers
    public List<Customer> getAllCustomers() {
        return this.customerRepo.findAll();
    }

    //list customer by id
    public Customer getCustomerById(long customerId) {
        return this.customerRepo.findById(customerId).orElse(null);
    }

    //delete
    public boolean deleteCustomer(long customerId) {
        boolean status = false;
        this.customerRepo.deleteById(customerId);
        if(this.getCustomerById(customerId)==null) {
            status = true;
        }
        return status;
    }

    //update
    public Customer updateCustomer(Customer customer) {
        return this.customerRepo.save(customer);
    }
}
