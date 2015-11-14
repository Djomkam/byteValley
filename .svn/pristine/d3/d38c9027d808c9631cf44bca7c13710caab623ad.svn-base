package com.social.manager.controller.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.social.manager.entities.User;
import com.social.manager.service.UserService;

@Controller
public class UsersController {
	
	@Autowired
	UserService userservice;
	
	private List<User> users;
	
	@RequestMapping(value={"/admin/user/users"}, method=RequestMethod.GET)
    public String showUsers(Model model) {
		users = userservice.findAll();
		model.addAttribute("users", users);
		
        return "/admin/user/users";
    }
}
