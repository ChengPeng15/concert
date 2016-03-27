package com.bjtu.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/concert")
public class ConcertController {
	
	@RequestMapping("/list")
	public ModelAndView getConcertList(){
		ModelAndView view = new ModelAndView();
		view.setViewName("");
		return view;
	}
	
	@RequestMapping("/info/{id}")
	public ModelAndView getConcertInfo(int id){
		ModelAndView view = new ModelAndView();
		view.setViewName("");
		return view;
	}
}
