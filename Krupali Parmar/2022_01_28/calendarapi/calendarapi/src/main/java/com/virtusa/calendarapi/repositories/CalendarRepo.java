package com.virtusa.calendarapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.calendarapi.models.Calendar;
import com.virtusa.calendarapi.models.Country;

public interface CalendarRepo extends JpaRepository<Calendar,Long>{

	//JPA refers class and fields not table
	/*
	 * @Query("select calendar from Calendar calendar where calendar.country=:country")
	public List<Calendar> findByCountry(@Param("country") Country country);
	*/
}
