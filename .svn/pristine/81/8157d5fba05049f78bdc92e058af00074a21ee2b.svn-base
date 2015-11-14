package com.social.manager.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.manager.entities.Social;
import com.social.manager.repository.SocialRepository;

@Service
@Transactional
public class SocialService {

	@Autowired
	SocialRepository repository;
	
	public Boolean create(Social social) {
		Social existingAccount = repository.findByAccountName(social.getAccountName());
		if (existingAccount != null) 
			return false;
		
		Social saved = repository.save(social);
		if (saved == null) 
			return false;
		
		return true;
	}
	
	public Boolean update(Social social) {
		Social existingAccount = repository.findByAccountName(social.getAccountName());
		if (existingAccount == null) 
			return false;
		
		// Only firstName, lastName, and role fields are updatable
		existingAccount.setAccountName(social.getAccountName());
		
		Social saved = repository.save(existingAccount);
		if (saved == null) 
			return false;
		
		return true;
	}
	
	public Boolean delete(Social social) {
		Social existingAccount = repository.findOne(social.getId());
		if (existingAccount == null) 
			return false;
		
		repository.delete(existingAccount);
		Social deletedAccount = repository.findOne(social.getId());
		if (deletedAccount != null) 
			return false;
		
		return true;
	}
	
	public List<Social> findAll(){
		List<Social> list = repository.findAll();
		return list;
	}
}
