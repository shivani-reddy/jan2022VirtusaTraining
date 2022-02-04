package com.customerApi.customer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerInput {
	private String customerName;
	private String address;
	private String country;
	private String bankdetails;


}
