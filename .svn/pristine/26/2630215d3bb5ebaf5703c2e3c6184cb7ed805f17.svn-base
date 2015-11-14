package com.social.manager.controller.admin.social;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.social.manager.entities.Social;
import com.social.manager.service.SocialService;

@Controller
public class AddSocialController {

	@Autowired
	SocialService service;
	
	@RequestMapping(value="/admin/social/add" , method=RequestMethod.GET)
	public String addSocialForm(Social social,Model model)
	{
		return "/admin/social/add";
	}
	
	@RequestMapping(value="/admin/social/add" , method=RequestMethod.POST)
	public String addSocial(@ModelAttribute("social")@Valid Social social,BindingResult result, Model model)
	{
		if(result.hasErrors())
			return "/admin/social/add";
		
		Social newAccount = new Social();
		newAccount.setAccountName(social.getAccountName());
		
		service.create(newAccount);
		
		return "redirect:/admin/social/social";
	}
}
