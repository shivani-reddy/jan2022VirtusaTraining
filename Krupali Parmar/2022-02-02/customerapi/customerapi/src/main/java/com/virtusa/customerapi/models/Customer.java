package com.virtusa.customerapi.models;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Customer_Id")
    private long customerId;
    
    @Embedded
    private FullName fullName;

    @Embedded
    private Address address;

    @Column(name="Customer_Email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name="Customer_Phone", length = 10, nullable = false)
    private String phone;

    @Column(name="Customer_Status")
    private boolean status;
    
    /*
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "Bank_Id"), name = "Bank_Id" )
	private Bank bank;
	*/
}
