package com.virtusa.customerapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.customerapi.models.Desk;

public interface DeskRepo extends JpaRepository<Desk,Long> {

}
