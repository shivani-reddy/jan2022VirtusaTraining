package com.virtusa.calendarapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.calendarapi.models.Calendar;
import com.virtusa.calendarapi.repositories.CalendarRepo;




@Service
public class CalendarService {
	@Autowired
	private CalendarRepo calendarRepo;
	
	//insert 
	
		public Calendar addCalendar(Calendar calendar) {
			return this.calendarRepo.save(calendar);
		}
		
	//list all customers
		
		
		public List<Calendar> getAllCalendar(){
			return this.calendarRepo.findAll();
		}
		
		//list customers by Id
		
		public Calendar getHolidayById(long holidayId) {
			return this.calendarRepo.findById(holidayId).orElse(null);
		}
		
		//delete

		public boolean deleteHolidayById(long holidayId) {
			boolean status=false;
			this.calendarRepo.deleteById(holidayId);
			if(this.getHolidayById(holidayId)==null)
				status=true;
			return status;
		}
		
		//update
		public Calendar updateCalendar(long holidayId,String calendarEvent) {
			
			Calendar calendar=this.getHolidayById(holidayId);
			if(calendar!=null) {
				calendar.setCalendarEvent(calendarEvent);
			}
			
			return this.calendarRepo.save(calendar);
		}
		
}
