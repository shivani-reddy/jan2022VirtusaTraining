package com.virtusa.calendarapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.calendarapi.models.Calendar;
import com.virtusa.calendarapi.models.Country;
import com.virtusa.calendarapi.repositories.CalendarRepo;

@Service
public class CalendarService {
	
	@Autowired
	private CalendarRepo calendarRepo;
	
	//insert 	
	public Calendar addCalendar(Calendar calendar) {
	/*
		 Country country=this.countryService.getCountryById(countryId);
		 if(country!=null) 
			 calendar.setCountry(country);			
		 
		 else
			 calendar.setCountry(null);
			*/
		 this.calendarRepo.save(calendar);
		 return calendar;
		 
		}
	
	//list all the traders
	
	public List<Calendar> getAllCalendars(){
		return this.calendarRepo.findAll();
	}
	
	//list trader by Id
	
	public Calendar getCalendarById(long calendarId) {
		return this.calendarRepo.findById(calendarId).orElse(null);
	}
	
	//delete

	public boolean deleteCalendarById(long calendarId) {
		boolean status=false;
		this.calendarRepo.deleteById(calendarId);
		if(this.getCalendarById(calendarId)==null)
			status=true;
		return status;
	}
	// update
	
	public Calendar updateCalendar(Calendar calendar) {
		return this.calendarRepo.save(calendar);
	}

	/*
	public List<Calendar> updateCountry(long countryId) {
		
		Country country=this.countryService.getCountryById(countryId);
		
		List<Calendar> calendarList=this.calendarRepo.findByCountry(country);
		
	    for(Calendar calendar:calendarList) {
	    	calendar.setCountry(null);
	    	this.calendarRepo.save(calendar);
	    }
		
		return calendarList;
	}
	*/
}
