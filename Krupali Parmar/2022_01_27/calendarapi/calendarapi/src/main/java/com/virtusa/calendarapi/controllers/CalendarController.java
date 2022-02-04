package com.virtusa.calendarapi.controllers;

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
import com.virtusa.calendarapi.models.Calendar;
import com.virtusa.calendarapi.services.CalendarService;

@RestController
@RequestMapping("/calendars")
public class CalendarController {

	   @Autowired
	    private CalendarService calendarService;

	    // Post
	    @PostMapping(value = "/", params = "version=1.0")
	    public ResponseEntity<?> addCalendar(@RequestBody Calendar calendar) {
	        Calendar calendarObj = this.calendarService.addCalendar(calendar);
	        if (calendarObj != null)
	            return ResponseEntity.status(HttpStatus.ACCEPTED).body(calendarObj);
	        else
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calendar not created");
	    }

	    // Get
	    @GetMapping(value = "/", params = "version=1.0")
	    public List<Calendar> getAllCurrencies() {
	        return this.calendarService.getAllCalendars();
	    }

	    // Get with Id
	    @GetMapping(value = "/{calendarId}", params = "version=1.0")
	    public ResponseEntity<?> getCalendarById(@PathVariable("calendarId") long calendarId) {
	        Calendar calendarObj = this.calendarService.getCalendarById(calendarId);
	        if (calendarObj != null)
	            return ResponseEntity.status(HttpStatus.ACCEPTED).body(calendarObj);
	        else
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calendar not found");
	    }

	    // Put
	    @PutMapping(value = "/{calendarId}", params = "version=1.0")
	    public ResponseEntity<?> updateCalendar(@RequestParam("calendarId") long calendarId,
	            @RequestBody Calendar calendar) {
	        Calendar calendarObj = this.calendarService.updateCalendar(calendar);
	        if (calendarObj != null)
	            return ResponseEntity.status(HttpStatus.ACCEPTED).body(calendarObj);
	        else
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calendar not found");

	    }

	    // Delete
	    @DeleteMapping(value = "/{calendarId}", params = "version=1.0")
	    public ResponseEntity<?> deleteCalendar(@PathVariable("calendarId") long calendarId) {
	        boolean result = this.calendarService.deleteCalendarById(calendarId);
	        if (result)
	            return ResponseEntity.ok("Successfully Deleted");
	        else
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calendar not deleted/Not Found");
	    }
}
