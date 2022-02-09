package com.ganga.calenderapi.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganga.calenderapi.services.models.Calender;

@Repository
public interface CalenderRepo extends JpaRepository<Calender,Long>{
	
	
}
