package com.bjtu.booking.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.booking.bean.Stadium;
import com.bjtu.booking.foo.Foo;
import com.bjtu.booking.service.StadiumService;

/**
 * Stadium Controller
 * @author SHAO
 *
 */
@Controller
@RequestMapping("/stadium")
public class StadiumController {

	/**
	 * Enable console output if set 1
	 */
	private int debug = 1;
	
	/**
	 * All things needed behind controller
	 */
	Foo foo = new Foo();
	
	@Resource
	private StadiumService stadiumService;
	
	/**
	 * Method to get stadium list, no limitation now
	 */	
	@RequestMapping("/list")
	public ModelAndView getStadiumList(ModelMap modelMap){
		ModelAndView view = new ModelAndView();
		
		List<Stadium> list = stadiumService.getStadiumList();
		modelMap.addAttribute("list", list);
		view.setViewName("user/stadium");
		return view;
	}
	
	/**
	 * Method to get one specified stadium info
	 * @param id stadium id in database
	 */
	@RequestMapping("/info/{id}")
	public ModelAndView getStadiumInfo(@PathVariable("id") int id, ModelMap modelMap){
		ModelAndView view = new ModelAndView();
		
		if(1 == debug){
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Requesting Stadium ID [" + id + "]");
		}
		
		/**
		 * Stadium entity
		 * Should contains stadium id, name, intro, address, total seats and a list of holding concerts 
		 * 
		 * Concert list entity
		 * should contains concert id, title, open time, end time, total tickets and sold tickets for each concert entity
		 */
		Stadium stadm = new Stadium();
		stadm = foo.getStadiumDetail(id);

		if (null == stadm) {
			view.setViewName("error");
			return view;
		}
		
		if(1 == debug){
			System.out.println("Name [" + stadm.getName() + "]");
			System.out.println("ID [" + stadm.getId() + "]");
			System.out.println("Address [" + stadm.getAddress() + "]");
			System.out.println("Intro [" + stadm.getIntro() + "]");
		}

		modelMap.addAttribute("stadium", stadm);

		view.setViewName("user/stadium_info");
		return view;
	}
}
