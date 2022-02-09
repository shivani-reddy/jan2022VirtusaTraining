package com.ganga.calenderapi.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ganga.calenderapi.services.CalenderService;
import com.ganga.calenderapi.services.models.Calender;

@Component
public class CalenderQueryResolver implements GraphQLQueryResolver{
	@Autowired
	private CalenderService calService;
	
	public List<Calender> findAllCalenders(){
		return this.calService.getAllCalenders();
	}
	
	public Calender findCalender(long id) {
	
		return this.calService.getCalenderById(id);
	}

}
