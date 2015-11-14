package com.social.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.manager.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
}
