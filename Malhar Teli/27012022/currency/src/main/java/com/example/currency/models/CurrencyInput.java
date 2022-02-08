package com.example.currency.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyInput {
    private String currencyCode;
    private String currencyCountry;
    private String currencySymbol;
    private Boolean tradableFlag;
    private String currencyDescription;
}
