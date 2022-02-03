package com.virtusa.customerapi.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Customer_Id",length=15)
	private long cutomerId;
	
	@Embedded
	private FullName name;
	
	@Column(name = "Email",length=20,nullable=false)
	private String Email;
	
	@Column(name = "DOB")
	private LocalDate dob;
	
	@Embedded
	private Address address;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "Bank_Id"), name = "Bank_Id" )
	private Bank bank;
	
}
