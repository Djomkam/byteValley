package com.social.manager.controller.admin.role;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.social.manager.entities.Roles;
import com.social.manager.service.RoleService;

@Controller
public class AddRoleController {

	@Autowired
	RoleService service;
	
	@RequestMapping(value="/admin/role/add" , method=RequestMethod.GET)
	public String addRoleForm(Roles role,Model model)
	{
		return "/admin/role/add";
	}
	
	@RequestMapping(value="/admin/role/add" , method=RequestMethod.POST)
	public String addRole(@ModelAttribute("roles")@Valid Roles roles,BindingResult result, Model model)
	{
		if(result.hasErrors())
			return "/admin/role/add";
		
		Roles newRole = new Roles();
		newRole.setRoleName(roles.getRoleName());
		
		service.create(newRole);
		
		return "redirect:/admin/role/roles";
	}
}
