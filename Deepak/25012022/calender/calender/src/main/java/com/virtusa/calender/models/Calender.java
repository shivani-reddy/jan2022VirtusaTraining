package com.virtusa.calender.models;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name="Calender")
public class Calender  {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name="Holiday_Id")
	private long holidayId;
	
	@Column(name="Event")
	private String event;
	@Column(name="Category")
	private String category;
	@Column(name="Date_Holiday")
	private LocalDate dateHoliday;
}
