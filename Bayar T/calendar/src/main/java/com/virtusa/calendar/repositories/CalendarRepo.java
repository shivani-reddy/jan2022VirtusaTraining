package com.virtusa.calendar.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.calendar.models.Calendar;

@Repository
public interface CalendarRepo extends JpaRepository<Calendar, Long>{

}
