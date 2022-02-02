package com.virtusa.currencyapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyInput {

    private String country;
    private Blob currencySymbol;
    private int tradableFlag;
    private String description;
}
