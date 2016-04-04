package com.bjtu.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.booking.bean.Order;
import com.bjtu.booking.foo.Foo;

/**
 * Order Controller
 * @author SHAO
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	
	/**
	 * Enable console output if set 1
	 */
	private int debug = 1;
	
	/**
	 * All things needed behind controller
	 */
	Foo foo = new Foo();
	
	@RequestMapping("/info/{id}")
	public ModelAndView getOrderInfo(@PathVariable("id")int id, ModelMap modelMap){
		ModelAndView view = new ModelAndView();
		
		if(1 == debug){
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Requesting Order Detail - ID [" + id + "]");
		}
		
		Order order = new Order();
		order = foo.getOrder(id);
		
		modelMap.addAttribute("order", order);
		view.setViewName("/user/user_orderdetail");
		return view;
	}
}
