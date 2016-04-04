package com.bjtu.booking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.booking.bean.Concert;
import com.bjtu.booking.foo.Foo;
import com.bjtu.booking.service.ConcertService;
import com.bjtu.booking.service.UserService;


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
	
	/**
	 * All things needed behind controller
	 */
	Foo foo = new Foo();
	
	@Resource
	private UserService userService;
	@Resource
	private ConcertService concertService;
	
	/**
	 * Method to get concert list, no limitation now
	 */
	@RequestMapping("/list")
	public ModelAndView getConcertList(ModelMap modelMap) {
		ModelAndView view = new ModelAndView();
		concertService.getConcertList();
		if(1 == debug){
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Requesting Concert list");
		}
		
		List<Concert> list = new ArrayList<Concert>();
		list = foo.getConcertList();
		
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
		Concert conct = new Concert();
		conct = foo.getConcertDetail(id);

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
