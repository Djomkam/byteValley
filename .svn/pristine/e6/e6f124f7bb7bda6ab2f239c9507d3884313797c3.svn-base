package com.social.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.manager.entities.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long>{

	//List<Roles> findByUser(User user);
	Roles findByRoleName(String roleName);
}
