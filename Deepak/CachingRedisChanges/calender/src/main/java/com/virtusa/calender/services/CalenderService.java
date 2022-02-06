package com.virtusa.calender.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
	@Cacheable(value="Calender")
	public List<Calender> getAllCalenders(){
		return this.calenderRepo.findAll();
	}
	
	//list by id
	@Cacheable(value="Calender", key="#holidayId")
	public Calender getCalenderById(long holidayId) {
		return this.calenderRepo.findById(holidayId).orElse(null);
	}
	
	//delete by id
	@CacheEvict(value="Calender", key="#holidayId")
	public boolean deleteCalenderById(long holidayId) {
		boolean status=false;
		this.calenderRepo.deleteById(holidayId);
		if(this.getCalenderById(holidayId)==null)
			status=true;
		return status;
	}
	
	//UPDATE
	@CachePut(value="Calender", key="#holidayId")
	public Calender updateCalender(long holidayId, String event){
		
		Calender calender=this.getCalenderById(holidayId);
		if(calender!=null)
			calender.setEvent(event);
		
		return this.calenderRepo.save(calender);
		
	}
	
}
