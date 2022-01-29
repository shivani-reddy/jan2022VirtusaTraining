package com.virtusa.currency.models;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "Currency")
public class Currency implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden=true)
	@Column(name="Currency_Id")
	private long currencyId;
	
	
	
	@Column(name="Country")
	private String country;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Tradeable_Flag")
	private long tradeable_flag;
	
	//https://www.pixeltrice.com/image-gallery-spring-boot-application-using-mysql-and-thymeleaf/
	//@Lob annotation is used for storing large objects to the database such as byte array or large string. In our case, we are storing the image in the form of a byte array.
	@Lob
    @Column(name = "Symbol", length = Integer.MAX_VALUE, nullable = true)
    private byte[] symbol;
}
