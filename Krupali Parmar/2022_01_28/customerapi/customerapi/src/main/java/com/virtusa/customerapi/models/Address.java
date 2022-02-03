package com.virtusa.customerapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Column(name="Street_Address", nullable = true)
    private String streetAddress;

    @Column(name="Address_City", nullable = true)
    private String city;

    @Column(name="Address_State", nullable = true)
    private String state;

    @Column(name="Address_Country", nullable = true)
    private String country;

    @Column(name="Address_Zip", nullable = true)
    private String zip;
}
