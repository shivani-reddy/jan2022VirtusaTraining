package com.virtusa.currencyapi.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.virtusa.currencyapi.models.Currency;
import com.virtusa.currencyapi.services.CurrencyService;
import com.virtusa.currencyapi.utilities.BlobHandler;

import java.util.List;

@Component
public class CurrencyQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private CurrencyService currencyService;
    BlobHandler blobHandler = new BlobHandler();



    public List<Currency> getAllCurrency(){
        List<Currency> currencyList=  this.currencyService.getAllCurrency();
        return currencyList;
    }

    public Currency getCurrencyById(long currencyId){
        return this.currencyService.getCurrencyById(currencyId);
    }
}
