package com.virtusa.currencyapi.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtusa.currencyapi.models.Currency;
import com.virtusa.currencyapi.models.CurrencyInput;
import com.virtusa.currencyapi.services.CurrencyService;
import com.virtusa.currencyapi.utilities.BlobHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private CurrencyService currencyService;
    // private CurrencyQueryResolver queryResolver;
    BlobHandler blobHandler = new BlobHandler();

    public Currency createCurrency(CurrencyInput currencyInput){
        byte[] byteObj = blobHandler.stringToBlob(currencyInput.getSymbol());
        Currency currencyObj = new Currency(0, currencyInput.getCurrencyCode(), currencyInput.getCountry(), byteObj, currencyInput.getTradableFlag().longValue(), currencyInput.getDescription());
        return this.currencyService.addCurrency(currencyObj);
    }
    public Currency updateCurrency(long currencyId, CurrencyInput currencyInput){
        byte[] byteObj = blobHandler.stringToBlob(currencyInput.getSymbol());
        Currency oldObj = this.currencyService.getCurrencyById(currencyId);
        Currency currencyObj = new Currency(currencyId, currencyInput.getCurrencyCode(), currencyInput.getCountry(), byteObj, currencyInput.getTradableFlag().longValue(), currencyInput.getDescription());
        if (oldObj!=null){
            return this.currencyService.updateCurrency(currencyId, currencyObj);

        }

        return null;
    }

    public boolean deleteCurrency(long currencyId){
        return this.currencyService.deleteCurrencyById(currencyId);
    }

}

