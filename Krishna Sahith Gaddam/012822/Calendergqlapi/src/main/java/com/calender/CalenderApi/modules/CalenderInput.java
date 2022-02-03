package com.calender.CalenderApi.modules;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CalenderInput {
	private String event;
	private String category;
	private LocalDate holiday;
	private long country_code;

}
