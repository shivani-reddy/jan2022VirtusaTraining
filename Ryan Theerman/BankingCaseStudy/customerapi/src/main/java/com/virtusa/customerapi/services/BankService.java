package com.virtusa.customerapi.services;

import com.virtusa.customerapi.models.Bank;
import com.virtusa.customerapi.repositories.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // communication between repo and model
public class BankService {
    @Autowired
    private BankRepo bankRepo;

    //insert
    public Bank addBank(Bank bank) {
        return this.bankRepo.save(bank);
    }

    //list all the banks
    public List<Bank> getAllBanks() {
        return this.bankRepo.findAll();
    }

    //list bank by id
    public Bank getBankById(long bankId) {
        return this.bankRepo.findById(bankId).orElse(null);
    }

    //delete
    public boolean deleteBank(long bankId) {
        boolean status = false;
        this.bankRepo.deleteById(bankId);
        if(this.getBankById(bankId)==null) {
            status = true;
        }
        return status;
    }

    //update
    public Bank updateBank(Bank bank) {
        return this.bankRepo.save(bank);
    }
}
