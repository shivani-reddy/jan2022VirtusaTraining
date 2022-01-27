package com.virtusa.customerapi.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name="Bank_Id")
    private long bankId;
    @Column(name="Bank_Name",length = 50,nullable = false)
    private String bankName;
    @Column(name="Address",length = 150,nullable = false)
    private String address;
}
