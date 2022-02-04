package com.virtusa.calendarapi.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name="Calendar")
public class Calendar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Holiday_Id",length=5)
	@ApiModelProperty(hidden = true)
	private long holidayId;
	
	@Column(name="Event",length=50)
	private String event;
	
	@Column(name="Category",length=25,nullable=false)
	private String category;
	
	@Column(name="Date_Holiday",nullable=false)
	private LocalDate dateHoliday;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "Country_Code"), name = "Country_Code" )
	private Country country;
}
