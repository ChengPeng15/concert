package com.bjtu.booking.controller;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.booking.bean.UserInfo;
import com.bjtu.booking.service.UserService;

/**
 * User Controller
 * @author SHAO
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	/**
	 * inject the user service
	 */
	@Resource
	private UserService userService;
	
	@RequestMapping("/info")
	public ModelAndView getUserInfo(@RequestParam("id")int id, @RequestParam(value="edit", required = false)Integer edit, ModelMap modelMap){
		ModelAndView view = new ModelAndView();
		
		if(null == edit){
			edit = 0;
		}
		
		UserInfo user = userService.getUserById(id);
		modelMap.addAttribute("edit", edit);
		modelMap.addAttribute("user", user);
		view.setViewName("/user/user_info");
		return view;
	}
	
	@RequestMapping(value="/changeinfo", method=RequestMethod.POST)
	public ModelAndView changeInfo(@RequestParam("id")int id, @RequestParam("email")String email, @RequestParam("mobile")String mobile, @RequestParam("address")String address, ModelMap modelMap){
		ModelAndView view = new ModelAndView();
		System.out.println("id is " + id);
		System.out.println("email is " + email);
		UserInfo user = new UserInfo();
		user.setId(id);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setAddress(address);
		userService.updateProfile(user);
//		modelMap.addAttribute("user", user);
		view.setViewName("redirect:info?id=" + id + "&edit=0");
		return view;
	}
	
	
	
	@RequestMapping("/order")
	public ModelAndView getUserOrder(@RequestParam("id")int id, ModelMap modelMap){
		ModelAndView view = new ModelAndView();
		
		if(1 == debug){
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Requesting User Order - ID [" + id + "]");
		}
		
		List<Order> list = new ArrayList<Order>();
		list = foo.getUserOrder(id);
		
		modelMap.addAttribute("list", list);
		view.setViewName("/user/user_order");
		return view;
	}
	
}
