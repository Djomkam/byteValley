package com.social.manager.controller.admin.social;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.social.manager.entities.Social;
import com.social.manager.service.SocialService;

@Controller
public class SocialController {

	@Autowired
	SocialService socialservice;
	
	private List<Social> accounts;
	
	@RequestMapping(value={"/admin/social/social"}, method=RequestMethod.GET)
    public String showUsers(Model model) {
		accounts = socialservice.findAll();
		model.addAttribute("accounts", accounts);
		
        return "/admin/social/social";
    }
}
