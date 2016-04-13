package com.bjtu.booking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.booking.bean.Concert;
import com.bjtu.booking.foo.Foo;

/**
 * Admin Controller
 * @author SHAO
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	/**
	 * Enable console output if set 1
	 */
	private int debug = 1;
	
	/**
	 * All things needed behind controller
	 */
	Foo foo = new Foo();
	
	/**
	 * Method to get concert list, no limitation now
	 */
	
	@RequestMapping("/concertslist")
	public ModelAndView getConcertList(ModelMap modelMap) {
		ModelAndView view = new ModelAndView();
		
		if(1 == debug){
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Requesting Concert list");
		}
		List<Concert> list = new ArrayList<Concert>();
		list = foo.getConcertList();
		
		modelMap.addAttribute("list", list);
		view.setViewName("admin/concert_list");
		return view;
	}
	
	@RequestMapping("/getconcert")
	public ModelAndView getConcertInfo(@RequestParam(required = false , value = "id")Integer id, ModelMap modelMap){
		ModelAndView view = new ModelAndView();
		
		if(1 == debug){
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Editing/Newing Concert");
		}
		
		if (null == id){
			if(1 == debug){
				System.out.println("--Newing");
			}
			modelMap.put("edit", 0);
		}

		if (null != id){
			if(1 == debug){
				System.out.println("--Editing");
				System.out.println("--ID [" + id + "]");
			}
			modelMap.put("edit", 1);
			Concert conct = new Concert();
			conct = foo.getConcertDetail(id);
			modelMap.addAttribute("concert", conct);
		}
		
		view.setViewName("admin/concert_edit");
		return view;
	}
}
