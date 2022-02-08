package com.virtusa.currencyapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.virtusa.currencyapi.models.Currency;
import com.virtusa.currencyapi.services.CurrencyService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@RequestMapping("/currency")
@RefreshScope
@Slf4j
public class CurrencyController {
	
    @Autowired
    private CurrencyService currencyService;
	@Value("${newmessage}")
	private String message;

    //	Post
    @PostMapping(value = "/", params = "version=1.0")
    public ResponseEntity<?> addCurrency(@RequestBody Currency currency){
        Currency currencyObj = this.currencyService.addCurrency(currency);
        if (currencyObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency not created");
    }

    //	Get
    @GetMapping(value = "/", params = "version=1.0")
    public List<Currency> getAllCurrencies(){
		log.info("message: "+message);
        return this.currencyService.getAllCurrency();
    }

    //	Get with Id
    @GetMapping(value = "/{currencyId}", params = "version=1.0")
    public ResponseEntity<?> getCurrencyById(@PathVariable("currencyId") long currencyId){
        Currency currencyObj = this.currencyService.getCurrencyById(currencyId);
        if (currencyObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency not found");
    }

    //	Put
    @PutMapping(value = "/{currencyId}", params = "version=1.0")
    public ResponseEntity<?> updateCurrency(@RequestParam("currencyId") long currencyId, @RequestBody Currency currency){
        Currency currencyObj = this.currencyService.updateCurrency(currencyId, currency);
        if (currencyObj != null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency not found");

    }
    //	Delete
    @DeleteMapping(value = "/{currencyId}", params = "version=1.0")
    public ResponseEntity<?> deleteCurrency(@PathVariable("currencyId") long currencyId){
        boolean result = this.currencyService.deleteCurrencyById(currencyId);
        if (result) return ResponseEntity.ok("Successfully Deleted");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency not deleted/Not Found");
    }
}