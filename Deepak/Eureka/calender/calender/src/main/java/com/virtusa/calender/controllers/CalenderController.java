package com.virtusa.calender.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;
import com.virtusa.calender.models.Calender;
import com.virtusa.calender.services.CalenderService;


@RestController
@RequestMapping("/calender")
public class CalenderController {

	@Autowired
	private CalenderService calenderService;
	
	//insert
		@PostMapping(value="/{holidayId}",params = "version=1.0")
		public ResponseEntity<?> addCalender(@PathVariable("holidayId") long holidayId ,@RequestBody Calender calender) {
			Calender calObj=this.calenderService.addCalender(calender);
			if(calObj!=null)
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(calObj);
			else
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
		}
	//get all
		@GetMapping(value="/",params = "version=1.0")
		public List<Calender> getAllCalenders(){
			return this.calenderService.getAllCalenders();
		}
	
		//get by id
		@GetMapping(value="/{holidayId}", params="version=1.0")
		public ResponseEntity<?> getCalenderById(@PathVariable("holidayId") long holidayId){
			Calender calobj=this.calenderService.getCalenderById(holidayId);
			if(calobj!=null)
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(calobj);
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" not found");
				
		}
		
		//update event
		@PutMapping(value="/{holidayId}/{event}",params = "version=1.0")
		public ResponseEntity<?> updateCalender(@PathVariable("holidayId") long holidayId,@PathVariable("event") String event){
			Calender calobj=this.calenderService.updateCalender(holidayId,event);
			if(calobj!=null)
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(calobj);
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("event not updated");
		}
		
		//delete by id
		@DeleteMapping(value="/{holidayId}", params="version 1.0")
		public ResponseEntity<?> deleteByCalenderId(@PathVariable("holidayId") long holidayId){
			if(this.calenderService.deleteCalenderById(holidayId))
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("holiday with"+holidayId+ "is deleted");
			else
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(" not found");
		}
		
		//get
		@GetMapping(value="/filters/{holidayId}",params = "version=1.0")
		public ResponseEntity<?> getCalenderByFields(@PathVariable("holidayId") long holidayId,
				@RequestParam(name = "fields", required = false) String fields){
			
			Map<Object,Object> model=new HashMap<>();
	    	
	    	Calender calender = this.calenderService.getCalenderById(holidayId);
	    	
	    	if(calender!=null)
	    	{
	    		//fields refers to runtime selection
	    		ObjectMapper mapper = Squiggly.init(new ObjectMapper(),fields);  		
				return ResponseEntity.ok(SquigglyUtils.stringify(mapper,calender));

	    	}
	    	else
	    	{
		         model.put("message", "calender not existing");
			        
		         return ResponseEntity.ok(model);
	    	}
		}
		
		
}
