package com.virtusa.currencyapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.currencyapi.models.Currency;
import com.virtusa.currencyapi.repositories.CurrencyRepo;


@Service
public class CurrencyService {
@Autowired
private CurrencyRepo currencyRepo;

//insert 

		public Currency addCurrency(Currency currency) {
			return this.currencyRepo.save(currency);
		}
		
	//list all Currency
		
		
		public List<Currency> getAllCurrency(){
			return this.currencyRepo.findAll();
		}
		
		//list Currency by Id
		
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
				
				public Currency updateCurrency(long currencyId,String currencyDescription) {
					
					Currency currency=this.getCurrencyById(currencyId);
					if(currency!=null) {
						currency.setCurrencyDescription(currencyDescription);
					}
					
					return this.currencyRepo.save(currency);
				}
				
		
		
		
	
}
