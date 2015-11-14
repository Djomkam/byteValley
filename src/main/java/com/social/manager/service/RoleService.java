package com.social.manager.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.manager.entities.Roles;
import com.social.manager.entities.User;
import com.social.manager.repository.RolesRepository;

@Service
@Transactional
public class RoleService {

	@Autowired
	RolesRepository repository;
	
	public Boolean create(Roles role) {
		Roles existingRole = repository.findByRoleName(role.getRoleName());
		if (existingRole != null) 
			return false;
		
		for(User user : role.getUsers())
			user.addRole(role);
		Roles saved = repository.save(role);
		if (saved == null) 
			return false;
		
		return true;
	}
	
	public Boolean update(Roles role) {
		Roles existingRole = repository.findByRoleName(role.getRoleName());
		if (existingRole == null) 
			return false;
		
		// Only firstName, lastName, and role fields are updatable
		existingRole.setRoleName(role.getRoleName());
		existingRole.setUsers(role.getUsers());
		Roles saved = repository.save(existingRole);
		if (saved == null) 
			return false;
		
		return true;
	}
	
	public Boolean delete(Roles role) {
		Roles existingRole = repository.findOne(role.getId());
		if (existingRole == null) 
			return false;
		
		repository.delete(existingRole);
		Roles deletedUser = repository.findOne(role.getId());
		if (deletedUser != null) 
			return false;
		
		return true;
	}
	
	public List<Roles> findAll(){
		List<Roles> list = repository.findAll();
		return list;
	}
}
