package com.virtusa.currencyapi.models;

import java.awt.Image;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Currency")
public class Currency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Currency_Code",length=3,nullable=false)
	private long currencyCode;
	
	@Column(name="Currency_Name", length = 50, nullable = false, unique = true)
    private String currencyName;
    
	@Column(name="Country_Name", length = 50, nullable = false)
    private String countryName;
	
	 @Column(name="Currency_Image", columnDefinition = "mediumblob")
    private byte[] currencyImage;

	 /*
    public Currency(String currencyName, String countryName){
        this.currencyName = currencyName;
        this.countryName = countryName;
    }

    public Currency(String currencyName, String countryName, byte[] currencyImage){
        this.currencyName = currencyName;
        this.countryName = countryName;
        this.currencyImage = currencyImage;
    }
    */
	
	
	
}
