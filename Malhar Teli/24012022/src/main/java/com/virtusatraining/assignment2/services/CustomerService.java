package com.virtusatraining.assignment2.services;

import com.virtusatraining.assignment2.models.Customer;
import com.virtusatraining.assignment2.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    //insert customer
    public Customer addCustomer(Customer customer){
        return this.customerRepo.save(customer);
    }
    //update customer
    public Customer updateCustomer(Customer customer){
        return this.customerRepo.save(customer);
    }
    //delete
    public boolean deleteCustomerById(long customerId){
        boolean status = false;
        this.customerRepo.deleteById(customerId);
        if(this.customerRepo.getById(customerId)==null){
            status=true;
        }
        return status;
    }

    //list all currencies
    public List<Customer> getAllCurrencies(){
        return this.customerRepo.findAll();
    }

    //fetch currency by id
    public Customer getCustomerById(long customerId){
        return this.customerRepo.getById(customerId);
    }
}
