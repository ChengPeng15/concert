package com.bjtu.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/stadium")
public class StadiumController {
	
	@RequestMapping("/list")
	public ModelAndView getStadiumList(){
		ModelAndView view = new ModelAndView();
		view.setViewName("");
		return view;
	}
	
	@RequestMapping("/info/{id}")
	public ModelAndView getStadiumInfo(int id){
		ModelAndView view = new ModelAndView();
		view.setViewName("");
		return view;
	}
}
