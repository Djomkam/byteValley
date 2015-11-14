package com.social.manager.controller.app;


import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.social.manager.entities.Roles;
import com.social.manager.entities.User;

@Controller
public class LoginController {
	
	@RequestMapping(value={"/","/login"}, method=RequestMethod.GET)
    public String showForm(User user) {
        return "login";
    }
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
    public String checkUserInfo(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        Set<Roles> roles = user.getRoles();
        for(Roles r : roles)
        System.out.println(r.getRoleName());
        if(roles.contains("ROLE_ADMIN"))
        	return "redirect:/admin/controlPanel";
        else
        	return "redirect:/home";
    }
}
