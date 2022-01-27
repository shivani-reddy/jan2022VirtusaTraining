package com.virtusa.calendar.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.calendar.models.Calendar;

public interface CalendarRepo extends JpaRepository<Calendar, Long>{

}
