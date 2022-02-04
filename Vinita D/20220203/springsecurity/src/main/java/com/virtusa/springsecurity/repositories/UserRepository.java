package com.virtusa.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.springsecurity.models.User;


public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
