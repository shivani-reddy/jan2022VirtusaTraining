package com.virtusa.customerapi.repositories;

import com.virtusa.customerapi.models.Bank;
import com.virtusa.customerapi.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    @Query("select customer from Customer customer where customer.bank=:bank")
    public List<Customer> findByBank(@Param("bank") Bank bank);

}
