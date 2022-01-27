package com.virtusa.currency.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Currency")
public class Currency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Currency_Code")
	private long currencyCode;
	
	@Column(name = "Country")
	private String country;
	
	@Column(name = "Tradeable_Flag")
	private boolean tradeableFlag;
	
	@Column(name = "Description")
	private String description;

	@Lob
	@Column(name = "Image")
	private byte[] image;
}
