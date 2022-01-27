package com.virtusa.calendarapi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.calendarapi.models.Calendar;

public interface CalendarRepo extends JpaRepository<Calendar,Long>{

}
