package com.bjtu.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.booking.bean.User;
import com.bjtu.booking.foo.Foo;

/**
 * User Controller
 * @author SHAO
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	/**
	 * Enable console output if set 1
	 */
	private int debug = 1;
	
	/**
	 * All things needed behind controller
	 */
	Foo foo = new Foo();
	
	@RequestMapping("/info")
	public ModelAndView getUserInfo(@RequestParam("id")int id, @RequestParam(value="edit", required = false)Integer edit, ModelMap modelMap){
		ModelAndView view = new ModelAndView();
		
		if(null == edit){
			edit = 0;
		}
		
		if(1 == debug){
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Requesting User Info - ID [" + id + "]");
		}
		
		User user = new User();
		user = foo.getUserInfo(id);
		
		modelMap.addAttribute("edit", edit);
		modelMap.addAttribute("user", user);
		view.setViewName("/user/user_info");
		return view;
	}
	
}
