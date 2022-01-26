package com.virtusa.currency.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.currency.models.Currency;
import com.virtusa.currency.repositories.CurrencyRepo;


@Service
public class CurrencyService {
	@Autowired
	private CurrencyRepo currencyRepo;
	
	//insert 
	
		public Currency addBank(Currency currency) {
			return this.currencyRepo.save(currency);
		}
		
		//list all the currency
		
		public List<Currency> getAllCurrency(){
			return this.currencyRepo.findAll();
		}
		
		//list currency by Id
		
		public Currency getCurrencyById(long currencyId) {
			return this.currencyRepo.findById(currencyId).orElse(null);
		}
		
		//delete

		public boolean deleteCurrencyById(long currencyId) {
			boolean status=false;
			this.currencyRepo.deleteById(currencyId);
			if(this.getCurrencyById(currencyId)==null)
				status=true;
			return status;
		}
		
		//update
		
		public Currency updateCurrency(Long currencyId, String country) {
			Currency currency=this.getCurrencyById(currencyId);
			if(currency!=null) {
				currency.setCountry(country);
			}
			
			return this.currencyRepo.save(currency);
		}
}
