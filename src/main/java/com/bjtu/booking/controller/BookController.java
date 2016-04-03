package com.bjtu.booking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.booking.bean.Order;
import com.bjtu.booking.bean.OrderDetail;
import com.bjtu.booking.bean.Ticket;
import com.bjtu.booking.foo.Foo;

/**
 * Book Controller
 * @author SHAO
 *
 */
@Controller
@RequestMapping("/ticket")
public class BookController {

	/**
	 * Enable console output if set 1
	 */
	private int debug = 1;
	
	Foo foo = new Foo();
	
	/**
	 * Method to get seats map data
	 * @param id area id
	 */
	@RequestMapping("/area")
	public ModelAndView area(@RequestParam("id") int id, ModelMap modelMap){
		ModelAndView view = new ModelAndView();
		
		if(1 == debug){
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Requesting Area ID [" + id + "]");
		}
		
		/**
		 * Seats Map 2-dimension list
		 * Break area tickets into rows for front end use
		 * Each ticket entity should contains ticket id, price and status
		 */
		List<List<Ticket>> seats = new ArrayList<List<Ticket>>();
		seats = foo.getSeatMap(id);
		
		if (seats.isEmpty()){
			view.setViewName("error");
			return view;
		}
		
		modelMap.addAttribute("seats", seats);
		modelMap.addAttribute("areaId", id);
		
		view.setViewName("user/seat");
		return view;
	}
	
	/**
	 * Method to generate orders
	 * @param ticket int array, chosen ticket(s) id
	 */
	@RequestMapping("/book")
	public ModelAndView book(@RequestParam("ticket") int ticket[], ModelMap modelMap){
		ModelAndView view = new ModelAndView();
		
		int pricecount = 0;
		Order order = new Order();
		List<OrderDetail> details = new ArrayList<OrderDetail>();
		for (int i : ticket) {
			OrderDetail detail = new OrderDetail();
			detail.setTicketId(i);
			detail.setOriginalPrice(i / 100 * 100);
			detail.setFinalPrice(i / 100 * 100);
			pricecount += i / 100 * 100;
			details.add(detail);
		}
		order.setConcertId((ticket[0]/100+1)/2);
		order.setDetail(details);
		order.settPrice(pricecount);
		
		modelMap.addAttribute("preorder", order);
		
		view.setViewName("user/pay");
		return view;
	}
	
	/**
	 * 
	 */
	@RequestMapping("/pay")
	public ModelAndView pay(){
		ModelAndView view = new ModelAndView();
		view.setViewName("");
		return view;
	}
}
