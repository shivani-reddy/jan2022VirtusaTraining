package com.virtusa.currencyapi.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.virtusa.currencyapi.models.Currency;


import lombok.Data;

@Data
@Entity
@Table(name = "Currency")
public class Currency {

	 @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="Currency_Id")
		private long currencyId;
	 
	 @Column(name="Country_Name", length = 50, nullable = false)
	    private String countryName;
	
	 @Column(name="Currency_Symbol", columnDefinition = "mediumblob")
	    private byte[] currencySymbol;
	 
	 @Column(name="Tradable_Flag",length=1)
	    private int tradableFlag;
	 
	 @Column(name="Currency_Description", length = 50, nullable = false)
	    private String currencyDescription;
	 
	 
}
