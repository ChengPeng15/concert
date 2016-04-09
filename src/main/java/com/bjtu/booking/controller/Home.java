package com.bjtu.booking.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjtu.booking.bean.Concert;
import com.bjtu.booking.bean.Stadium;
import com.bjtu.booking.service.ConcertService;
import com.bjtu.booking.service.StadiumService;

@Controller
public class Home {
	
	@Resource
	private ConcertService concertService;
	
	@Resource
	private StadiumService stadiumService;
	
	@RequestMapping("/home")
	public String home(ModelMap modelMap){
		List<Concert> latest3Concert = concertService.getLatest3Concert();
		modelMap.put("concerts", latest3Concert);
		List<Stadium> top3Stadium = stadiumService.getTop3Stadium();
		modelMap.put("stadiums", top3Stadium);
		return "user/home";
	}

}
