package com.virtusa.currencyapi.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Blob;

@Data
@Entity
@Table(name = " Currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Currency_Id")
    private long currencyId;
    //CURRENCY SYMBOL?
    @Column(name = "Symbol")
    private Blob currencySymbol;
    @Column(name = "Amount")
    private BigDecimal currencyAmount;
}
