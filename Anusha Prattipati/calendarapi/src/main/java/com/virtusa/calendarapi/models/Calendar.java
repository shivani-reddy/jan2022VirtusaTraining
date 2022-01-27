package com.virtusa.calendarapi.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import lombok.Data;


@Data
@Entity
@Table(name = "Calendar")
public class Calendar {

	   @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="Holiday_Id")
		private long holidayId;
		
	   @Column(name="Calendar_Category", length = 50, nullable = false)
	    private String calendarCategory;
	   @Column(name="Calendar_Event", length = 150, nullable = false)
	    private String calendarEvent;
		
		@DateTimeFormat(iso = ISO.DATE)
		@Column(name="Date_Holiday")
		private LocalDate dateHoliday;
		@Column(name="Calendar_Countrycode",length = 50,nullable = false)
		private String calendarCountrycode;
		

	}


