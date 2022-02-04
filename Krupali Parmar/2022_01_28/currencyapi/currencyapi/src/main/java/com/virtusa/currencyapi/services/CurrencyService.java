package com.virtusa.currencyapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.virtusa.currencyapi.models.Currency;
import com.virtusa.currencyapi.repositories.CurrencyRepo;

import java.util.List;

@Service
public class CurrencyService {
	
    @Autowired
    private CurrencyRepo currencyRepo;

    public Currency addCurrency(Currency currency){
        return this.currencyRepo.save(currency);
    }

	@CachePut(value="Currency", key="#currencyId")
    public Currency updateCurrency(long currencyId, Currency currency){
        Currency currencyObj = this.getCurrencyById(currencyId);
        if (currencyObj!=null){

        }
        return this.currencyRepo.save(currency);
    }

	@Cacheable(value="Currency")
    public List<Currency> getAllCurrency(){
        return this.currencyRepo.findAll();
    }

	@Cacheable(value="Currency", key="#currencyId")
    public Currency getCurrencyById(long currencyId){
        return this.currencyRepo.findById(currencyId).orElse(null);
    }

	@CacheEvict(value="Currency", key="#currencyId")
    public boolean deleteCurrencyById(long currencyId){
        this.currencyRepo.deleteById(currencyId);
        return (this.getCurrencyById(currencyId)==null);
    }
}
