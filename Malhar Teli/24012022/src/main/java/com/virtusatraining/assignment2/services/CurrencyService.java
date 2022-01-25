package com.virtusatraining.assignment2.services;

import com.virtusatraining.assignment2.models.Currency;
import com.virtusatraining.assignment2.repositories.CurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepo currencyRepo;

    //insert currency
    public Currency addCurrency(Currency currency){
        return this.currencyRepo.save(currency);
    }
    //update currency
    public Currency updateCurrency(Currency currency){
        return this.currencyRepo.save(currency);
    }
    //delete
    public boolean deleteCurrencyById(long currencyId){
        boolean status = false;
        this.currencyRepo.deleteById(currencyId);
        if(this.currencyRepo.getById(currencyId)==null){
            status=true;
        }
        return status;
    }

    //delete all
    public boolean deleteAllCurrency(){
        this.currencyRepo.deleteAll();
        if(this.currencyRepo.findAll().isEmpty()){
            return true;
        }
        return false;
    }

    //list all currencies
    public List<Currency> getAllCurrencies(){
        return this.currencyRepo.findAll();
    }

    //fetch currency by id
    public Currency getCurrencyById(long currencyId){
        return this.currencyRepo.getById(currencyId);
    }

}
