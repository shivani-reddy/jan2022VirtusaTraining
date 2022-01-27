package com.virtusa.customerapi.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name="Customer_Id")
    private long customerId;
    @Embedded
    private FullName customerName;
    @Column(name="Customer_Address",nullable = false)
    private String customerAddress;
    @Column(name="Customer_Country",nullable = false)
    private String customerCountry;
    @Column(name="Customer_Zip",nullable = false)
    private String customerZip;
    @Column(name="Customer_State",nullable = false)
    private String customerState;
    @Column(name="Customer_Phone",nullable = false)
    private String customerPhone;
    @Column(name="Customer_Email",nullable = false)
    private String customerEmail;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name="DOB",nullable = false)
    private LocalDate dob;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "Bank_Id"), name = "Bank_Id")
    private Bank bank;

}
