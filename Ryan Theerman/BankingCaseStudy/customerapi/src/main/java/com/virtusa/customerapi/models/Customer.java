package com.virtusa.customerapi.models;

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
    @Column(name="Customer_Id")
    private long customerId;
    @Embedded
    private FullName name;
    @Column(name="Email")
    private String email;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name="DOB")
    private LocalDate dob;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "Bank_Id"), name = "Bank_Id")
    private Bank bank;

}
