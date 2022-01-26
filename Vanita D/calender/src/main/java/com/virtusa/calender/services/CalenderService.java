package com.virtusa.calender.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.calender.models.Calender;
import com.virtusa.calender.repositories.CalenderRepository;


@Service
public class CalenderService {
	@Autowired
	private CalenderRepository cRepo;
	
	//insert 
	
	public Calender addCalender(Calender calender) {
		return this.cRepo.save(calender);
	}
	
	//list all the calender
	
	public List<Calender> getAllCalenders(){
		return this.cRepo.findAll();
	}
	
	//list Calender by Id
	
	public Calender getCalenderById(long calenderId) {
		return this.cRepo.findById(calenderId).orElse(null);
	}
	
	//delete

	public boolean deleteCalenderById(long calenderId) {
		boolean status=false;
		this.cRepo.deleteById(calenderId);
		if(this.getCalenderById(calenderId)==null)
			status=true;
		return status;
	}
	
	//update
	
	public Calender updateCalender(Long calenderId, String category) {
		Calender calender=this.getCalenderById(calenderId);
		if(calender!=null) {
			calender.setCategory(category);
		}
		
		return this.cRepo.save(calender);
	}
}
