package com.calender.CalenderApi.modules;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Calender")
public class Calender {
    public Calender(int holidayId2, String event2, String category2, LocalDate holiday2, long country_code2) {
		// TODO Auto-generated constructor stub
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name="Holiday_Id")
	private long holidayId;
    @Column(name="Event",length = 50,nullable = false)
	private String event;
    @Column(name="Category",length = 25,nullable = false)
	private String category;
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name="Holiday_Date")
    private LocalDate holiday;
    @Column(name="Country_code")
    private long country_code;


	

}
