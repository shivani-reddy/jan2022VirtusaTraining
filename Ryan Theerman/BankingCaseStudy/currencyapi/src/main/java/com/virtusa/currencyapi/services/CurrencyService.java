package com.virtusa.currencyapi.services;

import com.virtusa.currencyapi.models.Currency;
import com.virtusa.currencyapi.repositories.CurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepo currencyRepo;

    //insert
    public Currency addCurrency(Currency currency) {
        return this.currencyRepo.save(currency);
    }

    //list all the currencies
    public List<Currency> getAllCurrencies() {
        return this.currencyRepo.findAll();
    }

    //list currency by id
    public Currency getCurrencyById(long currencyId) {
        return this.currencyRepo.findById(currencyId).orElse(null);
    }

    //delete
    public boolean deleteCurrency(long currencyId) {
        boolean status = false;
        this.currencyRepo.deleteById(currencyId);
        if(this.getCurrencyById(currencyId)==null) {
            status = true;
        }
        return status;
    }

    //update
    public Currency updateCurrency(Currency currency) {
        return this.currencyRepo.save(currency);
    }


}
