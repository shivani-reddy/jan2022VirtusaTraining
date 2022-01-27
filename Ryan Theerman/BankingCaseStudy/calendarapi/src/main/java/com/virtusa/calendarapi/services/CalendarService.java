package com.virtusa.calendarapi.services;

import com.virtusa.calendarapi.models.Calendar;
import com.virtusa.calendarapi.repositories.CalendarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepo calendarRepo;

    //list all holidays
    public List<Calendar> getAllHolidays() {
        return this.calendarRepo.findAll();
    }

    //list holiday by id
    public Calendar getHolidayById(long holidayId) {
        return this.calendarRepo.findById(holidayId).orElse(null);
    }

    //insert
    public Calendar addHoliday(Calendar calendar) {
        return this.calendarRepo.save(calendar);
    }

    //update
    public Calendar updateHoliday(Calendar calendar) {
        return this.calendarRepo.save(calendar);
    }

    //delete
    public boolean deleteHolidayById(long holidayId) {
        boolean status = false;
        this.calendarRepo.deleteById(holidayId);
        if(this.getHolidayById(holidayId)==null) {
            status = true;
        }
        return status;
    }
}
