package com.example.currency.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Currency")
public class Currency {
    //Currency_Code
    @Id
    @Column(name="Currency_Code", length = 3, nullable = false)
    private String currencyCode;
    //Country
    @Column(name="Country", length = 20, nullable = false)
    private String country;
    //Symbol
    @Column(name="Symbol")
    private String symbol;
    //Tradable Flag
    @Column(name="Tradable_Flag", nullable=false)
    private Boolean tradableFlag;
    //Description
    @Column(name = "Description", length = 50)
    private String description;
}
