package com.virtusa.currencyapi.controllers;

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

import com.virtusa.currencyapi.models.Currency;
import com.virtusa.currencyapi.service.CurrencyService;






@RestController
@RequestMapping("/currency")

public class CurrencyController {
	
	@Autowired
	private CurrencyService currencyService;
	
	//post
	@PostMapping(value="/",params = "version=1.0")
	public ResponseEntity<?> addcurrency(@RequestBody Currency currency){
		Currency currencyObj=this.currencyService.addCurrency(currency);
		if(currencyObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Created");
	}
	

	
	//get
	
		@GetMapping(value="/",params = "version=1.0")
		public List<Currency> getAllCurrency(){
			return this.currencyService.getAllCurrency();
		}
		
		//get by id
		
		@GetMapping(value="/{currencyId}",params = "version=1.0")
		public ResponseEntity<?> getHolidayById(@PathVariable("currencyId") long currencyId){
			Currency currencyObj=this.currencyService.getCurrencyById(currencyId);
			if(currencyObj!=null)
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("currency Not Found");
			
		}
		
		//put
		
		@PutMapping(value="/{currencyId}/{currencyDescription}",params = "version=1.0")
		public ResponseEntity<?> updateBank(@PathVariable("currencyId") long currencyId,@PathVariable("currencyDescription") String currencyDescription){
			Currency currencyObj=this.currencyService.updateCurrency(currencyId,currencyDescription);
			if(currencyObj!=null)
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Created");
			
		}
		
		
		//delete
		
		@DeleteMapping(value="/{currencyId}",params = "version=1.0")
		public ResponseEntity<?> deleteCurrencyById(@PathVariable("currencyId") long currencyId){
		
			if(this.currencyService.deleteCurrencyById(currencyId))
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("Currencyr with "+currencyId+"Deleted");
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Found");
		}
}
