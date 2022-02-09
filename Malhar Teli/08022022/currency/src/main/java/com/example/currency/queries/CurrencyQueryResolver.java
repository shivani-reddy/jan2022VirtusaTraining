package com.example.currency.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.currency.models.Currency;
import com.example.currency.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrencyQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private CurrencyService currencyService;

    public List<Currency> findAllCurrency(){
        return this.currencyService.getAllCurrency();
    }

    public Currency findCurrencyByCode(String currencyCode) {return this.currencyService.findCurrencyByCode(currencyCode);}
}
