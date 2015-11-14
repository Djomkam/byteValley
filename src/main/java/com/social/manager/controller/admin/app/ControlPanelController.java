package com.social.manager.controller.admin.app;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.social.manager.entities.Roles;
import com.social.manager.entities.Social;
import com.social.manager.entities.User;
import com.social.manager.service.RoleService;
import com.social.manager.service.SocialService;
import com.social.manager.service.UserService;

@Controller
public class ControlPanelController {
	
	@Autowired
	UserService userservice;
	
	@Autowired
	RoleService roleservice;
	
	@Autowired
	SocialService socialservice;
	
	private List<User> users;
	private List<Social> accounts;
	private List<Roles> roles;
	
	@RequestMapping(value={"/admin/dashboard"}, method=RequestMethod.GET)
    public String showUsers(Model model) {
		
		users = userservice.findAll();
		model.addAttribute("users", users);
		roles = roleservice.findAll();
		Set<String> set = new HashSet<>();
		Set<Roles> set1 = new HashSet<>();
		for(Roles role: roles)
		{
			set.add(role.getRoleName());
		}
		for(String role : set)
		{
			set1.add(new Roles(role));
		}
		model.addAttribute("roles", set1);
		accounts = socialservice.findAll();
		model.addAttribute("accounts", accounts);
		
        return "/admin/controlPanel";
    }
}
