package com.virtusa.customerApi.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Customer_Id")
	@ApiModelProperty(hidden = true)
	private long customerId;
	@Embedded
	private FullName name;
	
	@Column(name="Customer_Address")
	private String customerAddress;
	@Column(name="Customer_City")
	private String customerCity;
	@Column(name="Customer_Country")
	private String customerCountry;
	@Column(name="Customer_Zip")
	private String customerZip;
	@Column(name="Customer_State")
	private String customerState;
	@Column(name="Customer_phone")
	private String customerPhone;
	@Column(name="Email")
	private String email;
	@Column(name="Customer_Status")
	private int customerStatus;
	
	
	

}
