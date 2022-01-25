package com.virtusa.customerapi.repositories;

import com.virtusa.customerapi.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
