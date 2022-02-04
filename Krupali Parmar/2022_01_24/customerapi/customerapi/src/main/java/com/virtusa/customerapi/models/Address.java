package com.virtusa.customerapi.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {
	
	@Column(name="Address",length=20,nullable=false)
	private String address;
	
	@Column(name="City",length=20,nullable=false)
	private String city;
	
	@Column(name="Country",length=20,nullable=false)
	private String country;
	
	@Column(name="Zipcode",length=5,nullable=false)
	private String zipcode;
	

	@Column(name="State",length=20,nullable=false)
	private String state;
	
}
