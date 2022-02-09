package com.ganga.calenderapi.mutations;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ganga.calenderapi.services.CalenderService;
import com.ganga.calenderapi.services.models.Calender;
import com.ganga.calenderapi.services.models.CalenderInput;


@Component
public class CalenderMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private CalenderService calService;
	
	public Calender createCalender(CalenderInput calInput) {
		return this.calService.addCalender(new Calender(0,calInput.getEvent(),LocalDate.parse(calInput.getDate())));
	}
	
	public Calender updateCalender(long Id,String event) {
		return this.calService.updateCalender(Id, event);
	}

}
