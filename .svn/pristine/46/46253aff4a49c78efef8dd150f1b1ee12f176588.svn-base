package com.social.manager.controller.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/lockscreen")
@Controller
public class LockScreenController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String sessionTimeOutHandle(Model model)
	{
		
		return "lockscreen";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String rateHandler(HttpServletRequest request) {
	    //your controller code
	    String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}

}
