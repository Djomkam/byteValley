package com.social.manager.controller.admin.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.social.manager.entities.Roles;
import com.social.manager.entities.User;
import com.social.manager.service.RoleService;
import com.social.manager.service.UserService;

@Controller
public class AddUserController {
	
	@Autowired
	UserService service;
	
	@Autowired
	RoleService roleservice;
	
	private static final Logger logger = LoggerFactory.getLogger(AddUserController.class);
	
	@RequestMapping(value="/admin/user/add" , method=RequestMethod.GET)
	public String addUserForm(User user,Model model)
	{
		List<Roles> roles = roleservice.findAll();
		Set<String> set = new HashSet<String>();
		Set<Roles> set1 = new HashSet<>();
		for(Roles role : roles)
		{
			set.add(role.getRoleName());
		}
		for(String role : set)
		{
			set1.add(new Roles(role));
		}
		model.addAttribute("rols", set1);
		return "/admin/user/add";
	}
	
	@RequestMapping(value="/admin/user/add" , method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user")@Valid User user,BindingResult result, Model model)//, @RequestParam("roles") List<String> role)
	{
		if(result.hasErrors())
			return "/admin/user/add";
		
		User newUser = new User();
		
		//logger.info("The role size " + role.size());
		
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setRoles(user.getRoles());
		
		logger.info("The role size is " + user.getRoles().size());
		
		for(Roles rol: newUser.getRoles())
			logger.info("The role is " + rol.getRoleName());
		
		service.create(newUser);
		
		return "redirect:/admin/user/users";
	}

}
