package com.virtusa.calender.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.calender.models.Calender;

public interface CalenderRepo extends JpaRepository<Calender, Long> {

}
