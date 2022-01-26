package com.virtusa.customer.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Address {
	
	@Column(name="Road_Name",length = 50,nullable = false)
	private String roadName;
	
	@Column(name="City",length = 50,nullable = false)
	private String city;
	
	@Column(name="Country",length = 50,nullable = false)
	private String country;
	
	@Column(name="Zipcode",length = 50,nullable = false)
	private String zipCode;
	
}
