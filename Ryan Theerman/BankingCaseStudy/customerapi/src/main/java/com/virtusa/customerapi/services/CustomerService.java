package com.virtusa.customerapi.services;

import com.virtusa.customerapi.models.Bank;
import com.virtusa.customerapi.models.Customer;
import com.virtusa.customerapi.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private BankService bankService;

    //insert
    public Customer addCustomer(long bankId, Customer customer) {
        Bank bank=this.bankService.getBankById(bankId);
        if(bank!=null)
            customer.setBank(bank);

        else
            customer.setBank(null);
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
    public Customer updateCustomer(Customer customer) {
        return this.customerRepo.save(customer);
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
