package com.virtusatraining.assignment2.models;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Customer_Id")
    private long id;
    @Embedded
    private FullName name;
    @Column(name="Credit_Line")
    private long creditLine;
    @Column(name="Email")
    private String email;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name="Currency_Id"), name="Currency_Id")
    private Currency currency;



}
