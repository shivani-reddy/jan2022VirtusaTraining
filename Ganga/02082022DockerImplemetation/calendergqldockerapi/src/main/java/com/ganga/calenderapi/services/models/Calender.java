package com.ganga.calenderapi.services.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="Calender")
@AllArgsConstructor
@NoArgsConstructor
public class Calender {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Holiday_Id")
	private long id;
	@Column(name ="Calender_Event",length = 50,nullable = false)
	private String event;
	@Column(name ="Calender_Date")
	private LocalDate date;
	

}
