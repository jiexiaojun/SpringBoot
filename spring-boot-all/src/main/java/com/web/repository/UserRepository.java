package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.model.BasUser;

public interface UserRepository extends JpaRepository<BasUser, Long> {

	BasUser findByUserName(String userName);

	BasUser findByUserNameOrEmail(String username, String email);
    
	BasUser findById(Long id);
}