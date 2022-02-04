package com.virtusa.calender.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.calender.models.Calender;
import com.virtusa.calender.repositories.CalenderRepo;

@Service
public class CalenderService {
	
	@Autowired
	private CalenderRepo calenderRepo;

	//insert
	public Calender addCalender(Calender calender) {
		return this.calenderRepo.save(calender);
	}
	
	//list all 
	public List<Calender> getAllCalenders(){
		return this.calenderRepo.findAll();
	}
	
	//list by id
	public Calender getCalenderById(long holidayId) {
		return this.calenderRepo.findById(holidayId).orElse(null);
	}
	
	//delete by id
	public boolean deleteCalenderById(long holidayId) {
		boolean status=false;
		this.calenderRepo.deleteById(holidayId);
		if(this.getCalenderById(holidayId)==null)
			status=true;
		return status;
	}
	
	//UPDATE
	public Calender updateCalender(long holidayId, String event){
		
		Calender calender=this.getCalenderById(holidayId);
		if(calender!=null)
			calender.setEvent(event);
		
		return this.calenderRepo.save(calender);
		
	}
	
}
