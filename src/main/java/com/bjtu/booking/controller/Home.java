package com.bjtu.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
	
	@RequestMapping("/home")
	public String home(ModelMap modelMap){
		return "index";
	}

}
