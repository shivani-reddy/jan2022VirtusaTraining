package com.virtusa.customerapi.services;

import com.virtusa.customerapi.models.Customer;
import com.virtusa.customerapi.models.FullName;
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
        this.customerRepo.save(customer);
        return customer;
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
    public boolean deleteCustomerById(long customerId) {
        boolean status = false;
        this.customerRepo.deleteById(customerId);
        if(this.getCustomerById(customerId)==null) {
            status = true;
        }
        return status;
    }

    //update
    public Customer updateCustomer(long customerId,
                                   FullName customerName,
                                   String customerAddress,
                                   String customerCountry,
                                   String customerZip,
                                   String customerState,
                                   String customerPhone,
                                   String customerEmail,
                                   String dob) {

        Customer customer=this.getCustomerById(customerId);
        if(customer!=null) {
            customer.setCustomerName(customerName);
            customer.setCustomerAddress(customerAddress);
            customer.setCustomerCountry(customerCountry);
            customer.setCustomerZip(customerZip);
            customer.setCustomerState(customerState);
            customer.setCustomerPhone(customerPhone);
            customer.setCustomerEmail(customerEmail);
            customer.setDob(dob);
        }
        return this.customerRepo.save(customer);
    }

    public Boolean deleteCustomer(Long customerId) {
        Customer customer=this.getCustomerById(customerId);
        if(customer!=null) {
            this.customerRepo.deleteById(customerId);
            return true;
        } else {
            return false;
        }
    }

}
