package com.bjtu.booking.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.booking.bean.Concert;
import com.bjtu.booking.service.ConcertService;


/**
 * Concert Controller
 * @author SHAO
 *
 */
@Controller
@RequestMapping("/concert")
public class ConcertController {

	/**
	 * Enable console output if set 1
	 */
	private int debug = 1;
	
	@Resource
	private ConcertService concertService;
	
	/**
	 * Method to get concert list, no limitation now
	 */
	@RequestMapping("/list")
	public ModelAndView getConcertList(ModelMap modelMap) {
		ModelAndView view = new ModelAndView();
		
		List<Concert> list = concertService.getConcertList();
		
		modelMap.addAttribute("list", list);
		view.setViewName("user/concert");
		return view;
	}

	/**
	 * Method to get one specified concert info
	 * @param id concert id in database
	 */
	@RequestMapping("/info/{id}")
	public ModelAndView getConcertInfo(@PathVariable("id") int id, ModelMap modelMap) {
		ModelAndView view = new ModelAndView();

		if (1 == debug){
			System.out.println("== Getting concert info ==");
			System.out.println("ID = [" + id + "]");
		}
		
		/**
		 * Concert entity
		 * Should contains concert id, title, intro, stadium name, open time, end time, total tickets, sold tickets and a list of areas 
		 * 
		 * Area list entity
		 * should contains area id, name, total tickets and sold tickets for each area entity
		 */
		Concert conct = concertService.getConcertById(id);

		if (null == conct || conct.getAreas().isEmpty()) {
			view.setViewName("error");
			return view;
		}
		
		if(1 == debug){
			System.out.println("Title [" + conct.getTitle() + "]");
			System.out.println("ID [" + conct.getId() + "]");
			System.out.println("StadiumName [" + conct.getStadiumName() + "]");
			System.out.println("Intro [" + conct.getIntro() + "]");
		}

		modelMap.addAttribute("concert", conct);

		view.setViewName("user/concert_info");
		return view;
	}
}
