package com.virtusa.customerapi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.customerapi.models.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long>{

}
