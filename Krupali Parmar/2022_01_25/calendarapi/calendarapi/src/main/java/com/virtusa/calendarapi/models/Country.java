package com.virtusa.calendarapi.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name="Country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden=true)
	@Column(name = "Currency_Code",length=3,nullable=false)
	private long currencyCode;
	
	@Column(name = "Currency_Country",length=20,nullable=false)
	private String currencyCountry;
	
	/*
	 * @Column(name = "Currency_Image")
	private Image currencyImg;
	*/
	
	@Column(name="Tradable_Flag",length=1,nullable=false)
	private int tradableFlag;
	
}