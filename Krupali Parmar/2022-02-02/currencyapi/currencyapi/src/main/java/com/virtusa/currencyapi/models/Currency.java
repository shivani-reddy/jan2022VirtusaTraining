package com.virtusa.currencyapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

@Data
@Entity
@Table(name="Currency")
@AllArgsConstructor
@NoArgsConstructor
public class Currency implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Currency_Id")
    private long currencyId;
    
    @Column(name="Currency_Code", length = 3, nullable = false)
    private String currencyCode;

    @Column(name="Country", length = 20, nullable = false)
    private String country;

    @Column(name="Symbol", columnDefinition = "mediumblob")
    private byte[] symbol;

    @Column(name="Tradable_Flag", nullable=false)
    private long tradableFlag;

    @Column(name = "Description", length = 50)
    private String description;

}

