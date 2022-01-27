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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import lombok.Data;


@Data
@Entity
@Table(name = "Customer")
public class Customer {

	   @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="Customer_Id")
		private long customerId;
		@Embedded
		//value object
		private FullName name;
		
		@Column(name="Email")
		private String email;
		@DateTimeFormat(iso = ISO.DATE)
		@Column(name="DOB")
		private LocalDate dob;
		@Column(name="Address",length = 150,nullable = false)
		private String address;
		

	}


