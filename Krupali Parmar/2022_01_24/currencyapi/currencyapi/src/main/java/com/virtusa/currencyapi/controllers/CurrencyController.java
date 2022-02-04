package com.virtusa.currencyapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;
import com.virtusa.currencyapi.models.Currency;
import com.virtusa.currencyapi.services.CurrencyService;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
	@Autowired
	private CurrencyService currencyService;
	
	//post
	@PostMapping(value="/",params = "version=1.0")
	public ResponseEntity<?> addTrader(@RequestBody Currency currency){
		Currency currencyObj=this.currencyService.addCurrency(currency);
		if(currencyObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Created");
		
	}
	
	//get
	@GetMapping(value="/",params = "version=1.0")
	public List<Currency> getAllCurrency(){
		return this.currencyService.getAllCurrencies();
	}
	
	//get with id
	@GetMapping(value="/{currencyId}",params = "version=1.0")
	public ResponseEntity<?> getCurrencyById(@PathVariable("currencyId") long currencyId){
		Currency currencyObj=this.currencyService.getCurrencyById(currencyId);
		if(currencyObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Found");
		
	}
	
	//put
	@PutMapping(value="/",params = "version=1.0")
	public ResponseEntity<?> updateCurrency(@RequestBody Currency currency){

		Currency currencyObj=this.currencyService.updateCurrency(currency);
		if(currencyObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Updated");
		
	}
	
	//delete
	
	@DeleteMapping(value="/{currencyId}",params = "version=1.0")
	public ResponseEntity<?> deleteCurrencyById(@PathVariable("currencyId") long currencyId){
	
		if(this.currencyService.deleteCurrencyById(currencyId))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Currency with "+currencyId+"Deleted");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Found");
		
	}


	//get
	@GetMapping(value="/filters/{currencyId}",params = "version=1.0")
	public ResponseEntity<?> getCurrencyByFields(@PathVariable("currencyId") long currencyId,
			@RequestParam(name = "fields", required = false) String fields){
		
		Map<Object,Object> model=new HashMap<>();
    	
    	Currency currency = this.currencyService.getCurrencyById(currencyId);
    	
    	if(currency!=null)
    	{
    		//fields refers to runtime selection
    		ObjectMapper mapper = Squiggly.init(new ObjectMapper(), fields);  		
			return ResponseEntity.ok(SquigglyUtils.stringify(mapper, currency));

    	}
    	else
    	{
	         model.put("message", "currency not existing");
	         return ResponseEntity.ok(model);
    	}	
	}
}
