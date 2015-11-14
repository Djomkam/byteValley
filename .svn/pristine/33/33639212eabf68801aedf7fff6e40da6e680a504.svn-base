package com.social.manager.controller.admin.role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.social.manager.entities.Roles;
import com.social.manager.service.RoleService;

@Controller
public class RolesController {
	
	@Autowired
	RoleService roleservice;
	
	private List<Roles> roles;
	
	@RequestMapping(value={"/admin/role/roles"}, method=RequestMethod.GET)
    public String showUsers(Model model) {
		roles = roleservice.findAll();
		Set<String> set = new HashSet<>();
		for(Roles role : roles)
		{
			set.add(role.getRoleName());
		}
		model.addAttribute("roles", set);
		
        return "/admin/role/roles";
    }
}
