package com.calender.CalenderApi.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.calender.CalenderApi.modules.Calender;
import com.calender.CalenderApi.services.CalenderServices;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;


@Component

public class CalenderQueryResover implements GraphQLQueryResolver{
	@Autowired
	private CalenderServices calenderService;
	
	public List<Calender> findAllCalenders(){
		return this.calenderService.getAllCalenders();
	}
	
	public Calender findCalender(long holidayId) {
	
		return this.calenderService.getHolidayById(holidayId);
	}

}
