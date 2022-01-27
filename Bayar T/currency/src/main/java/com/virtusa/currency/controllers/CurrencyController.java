package com.virtusa.currency.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.currency.models.Currency;
import com.virtusa.currency.services.CurrencyService;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
	@Autowired
	private CurrencyService currencyService;
	

	@PostMapping(value="/",params = "version=1.0")
	public ResponseEntity<?> addCurrency(@RequestBody Currency currency) {
		Currency currencyObj = this.currencyService.addCurrency(currency);
		if(currencyObj != null) 
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Created");
	}
	
	@GetMapping(value="/",params = "version=1.0")
	public List<Currency> getAllCurrency() {
		return this.currencyService.getAllCurrency();
	}
	
	@GetMapping(value="/{customerId}", params = "version=1.0")
	public ResponseEntity<?> getCurrencyById(@PathVariable("currencyId") long currencyId) {
		Currency currencyObj = this.currencyService.getCurrencyById(currencyId);
		if(currencyObj != null)
			return  ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency does not exist");
	}
	
	@PutMapping(value="/{currencyId}",params = "version=1.0")
	public ResponseEntity<?> updateCurrency(@PathVariable("currencyId") long currencyId){
		Currency currencyObj=this.currencyService.updateCurrency(currencyId);
		if(currencyObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Created");
		
	}
	
	@DeleteMapping(value="/{currencyId}",params = "version=1.0")
	public ResponseEntity<?> deleteCurrencyById(@PathVariable("currencyId") long currencyId){
		if(this.currencyService.deleteCurrencyById(currencyId))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Currency with "+currencyId+"Deleted");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Found");
		
	}
}
