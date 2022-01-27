package com.virtusa.calendarapi.repositories;

import com.virtusa.calendarapi.models.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepo extends JpaRepository<Calendar, Long> {
}
