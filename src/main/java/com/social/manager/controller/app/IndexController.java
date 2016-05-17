package com.social.manager.controller.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;

@Controller
public class IndexController {

	@RequestMapping(value="/index",method = RequestMethod.GET)
	public ModelAndView homepage(Model model)
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		return view;
	}
	
	
	@RequestMapping(value="/test", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public String test(@RequestParam("id") int id) {
		System.out.println(id + " id");
		
		
		JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", id);
        
        System.out.println(jsonObject);
        
		return jsonObject.toString();
	}
}
