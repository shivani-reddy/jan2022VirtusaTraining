package com.virtusa.calendarapi.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Calendar")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name = "Holiday_Id")
    private long holidayId;
    @Column(name="Event")
    private String event;
    @Column(name="Category",nullable = false)
    private String category;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name="Date_Holiday",nullable = false)
    private LocalDate dateHoliday;

    // FK from currency?
    @Column(name="Country_Code")
    private String countryCode;



}
