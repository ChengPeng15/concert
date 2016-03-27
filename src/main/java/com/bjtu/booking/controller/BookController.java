package com.bjtu.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ticket")
public class BookController {

	@RequestMapping("/book")
	public ModelAndView book(){
		ModelAndView view = new ModelAndView();
		view.setViewName("");
		return view;
	}
	
	@RequestMapping("/pay")
	public ModelAndView pay(){
		ModelAndView view = new ModelAndView();
		view.setViewName("");
		return view;
	}
}
