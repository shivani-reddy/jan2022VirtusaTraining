package com.virtusa.customer.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Customer_Id")
	private long customerId;
	
	@Column(name = "Balance")
	private long balance;
	
	@Column(name = "Name",length = 50,nullable = false)
	private String name;
	
	@Column(name = "Email")
	private String email;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "Dob")
	private LocalDate dob;

}
