package com.social.manager.controller.facebook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/facebook/dashboard")
@Controller
public class FacebookDashboardController {

	@RequestMapping(method=RequestMethod.GET)
	public String getDasboard(Model model)
	{
		return "/facebook/dashboard";
	}
}
