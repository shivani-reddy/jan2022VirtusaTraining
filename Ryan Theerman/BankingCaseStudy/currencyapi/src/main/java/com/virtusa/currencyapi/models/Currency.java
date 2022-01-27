package com.virtusa.currencyapi.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;

@Data
@Entity
@Table(name = "Currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name = "Currency_Id")
    private long currencyId;
    @Column(name="Country",length=50,nullable = false)
    private String country;
    //CURRENCY SYMBOL?
    @Column(name = "Symbol")
    private Blob currencySymbol;
    @Column(name="Tradable_Flag",nullable = false)
    private int tradableFlag;
    @Column(name = "Description")
    private String description;
}
