package com.virtusa.currencyapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.currencyapi.models.Currency;
import com.virtusa.currencyapi.repositories.CurrencyRepo;

@Service
public class CurrencyService {

	@Autowired
	private CurrencyRepo currencyRepo;
	
	// CRUD Operation
	
	// Add(Create) Currency
	public Currency addCurrency(Currency currency) {
		return this.currencyRepo.save(currency);
	}
	
	// Get(Retrieve) All Currencies
	public List<Currency> getAllCurrencies(){
		return this.currencyRepo.findAll();
	}
	
	// Get(Retrieve) Currency by id
	public Currency getCurrencyById(long currencyId) {
		return this.currencyRepo.findById(currencyId).orElse(null);
	}
	
	// Update Currency
	public Currency updateCurrency(Currency currency) {
		return this.currencyRepo.save(currency);
	}
	
	// Delete Currency
	public boolean deleteCurrencyById(long currencyId) {
		boolean isDeleted = false;
		this.currencyRepo.deleteById(currencyId);
		if(this.getCurrencyById(currencyId)==null)
			isDeleted=true;
		
		return isDeleted;
	}
}
