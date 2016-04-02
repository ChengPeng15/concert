package com.bjtu.booking.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.booking.bean.Area;
import com.bjtu.booking.bean.Concert;
import com.bjtu.booking.foo.Foo;


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
	
	
	Foo foo = new Foo();
	/**
	 * 
	 */
	@RequestMapping("/list")
	public ModelAndView getConcertList(ModelMap modelMap) {
		ModelAndView view = new ModelAndView();
		
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
		 */
		Concert conct = new Concert();
		/**
		 * Area list entity
		 * should contains area id, name, total tickets and sold tickets for each area entity
		 */
		List<Area> lista = new ArrayList<Area>();

		if (1 == id) {
			Area area1 = new Area();
			area1.setId(1);
			area1.setName("East");
			area1.setTotal(20);
			area1.setSold(1);
			lista.add(area1);
			Area area2 = new Area();
			area2.setId(2);
			area2.setName("West");
			area2.setTotal(10);
			area2.setSold(8);
			lista.add(area2);
		}
		if (2 == id) {
			Area area1 = new Area();
			area1.setId(3);
			area1.setName("North");
			area1.setTotal(30);
			area1.setSold(10);
			lista.add(area1);
			Area area2 = new Area();
			area2.setId(4);
			area2.setName("South");
			area2.setTotal(12);
			area2.setSold(5);
			lista.add(area2);
		}
		if (lista.isEmpty()) {
			view.setViewName("error");
			return view;
		}

		conct.setAreas(lista);
		conct.setId(id);
		conct.setOpen(new Timestamp((new Date()).getTime()));
		conct.setEnd(new Timestamp((new Date()).getTime()));
		conct.setTitle("Concert " + id);
		conct.setIntro("Concert " + id + " will be a great success.");
		conct.setStadiumName("Stadium " + id);
		conct.setTotal(18 + id * 12);
		conct.setSold(3 + id * 6);
		
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
