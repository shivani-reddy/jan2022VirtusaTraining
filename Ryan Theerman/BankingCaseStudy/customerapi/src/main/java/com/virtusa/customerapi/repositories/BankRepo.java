package com.virtusa.customerapi.repositories;

import com.virtusa.customerapi.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<Bank, Long> {
}
