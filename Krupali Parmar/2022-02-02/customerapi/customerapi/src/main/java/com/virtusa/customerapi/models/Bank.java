package com.virtusa.customerapi.models;


import lombok.Data;

import javax.persistence.*;
import io.swagger.annotations.ApiModelProperty;


@Data
@Entity
@Table(name="Bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden=true)
    @Column(name="Bank_Id")
    private long bankId;

    @Column(name="Nostro_Account",nullable=true)
    private long  nostroAccount;

    @Column(name="Bank_Name",length=50,nullable=true)
    private String bankName;

    @Column(name="Bank_Legal_Entity",length=50,nullable=true)
    private String bankLegalEntity;

    @Embedded
    private Address address;

}
