package com.calender.CalenderApi.mutations;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.calender.CalenderApi.modules.Calender;
import com.calender.CalenderApi.modules.CalenderInput;
import com.calender.CalenderApi.services.CalenderServices;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Component
public class CalenderMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private CalenderServices calenderService;
	
	public Calender createCalender(CalenderInput calenderInput) {
		return this.calenderService.addCalender(new Calender(0,calenderInput.getEvent(),calenderInput.getCategory(),calenderInput.getHoliday(),calenderInput.getCountry_code()));
	}
	
	public Calender updateCalender(long holidayId,String event) {
		return this.calenderService.updateCalender(holidayId, event);
	}


}
