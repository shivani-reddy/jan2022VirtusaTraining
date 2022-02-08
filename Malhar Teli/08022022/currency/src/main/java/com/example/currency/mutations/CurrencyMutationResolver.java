package com.example.currency.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.currency.models.Currency;
import com.example.currency.models.CurrencyInput;
import com.example.currency.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private CurrencyService currencyService;

    public Currency createCurrency(CurrencyInput currencyInput){
        Currency currencyObj = new Currency(
                currencyInput.getCurrencyCode(),
                currencyInput.getCurrencyCountry(),
                currencyInput.getCurrencySymbol(),
                currencyInput.getTradableFlag(),
                currencyInput.getCurrencyDescription()
        );
        return this.currencyService.addCurrency(currencyObj);
    }
    public Currency updateCurrency(CurrencyInput currencyInput){
        Currency currencyObj = new Currency(
                currencyInput.getCurrencyCode(),
                currencyInput.getCurrencyCountry(),
                currencyInput.getCurrencySymbol(),
                currencyInput.getTradableFlag(),
                currencyInput.getCurrencyDescription()
        );
        return  this.currencyService.updateCurrency(currencyInput.getCurrencyCode(), currencyObj);
    }
}
