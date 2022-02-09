package com.example.currency.services;

import com.example.currency.models.Currency;
import com.example.currency.repositories.CurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepo currencyRepo;

    //insert
    public Currency addCurrency(Currency currency){
        return this.currencyRepo.save(currency);
    }
    //update
    public Currency updateCurrency(String currencyCode, Currency currency){
        Currency currencyObj = this.findCurrencyByCode(currencyCode);
        if (currencyObj!=null){
            this.currencyRepo.save(currency);
        }
        return this.currencyRepo.save(currency);
    }

    //List all
    public List<Currency> getAllCurrency(){
        return this.currencyRepo.findAll();
    }

    public Currency findCurrencyByCode(String currencyId){
        return this.currencyRepo.findCurrencyByCode(currencyId);
    }

    public boolean deleteCurrencyById(String currencyCode){
        this.currencyRepo.deleteById(currencyCode);
        return (this.findCurrencyByCode(currencyCode)==null);
    }
}
