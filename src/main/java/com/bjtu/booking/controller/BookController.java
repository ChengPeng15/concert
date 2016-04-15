package com.bjtu.booking.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.booking.bean.Order;
import com.bjtu.booking.bean.Ticket;
import com.bjtu.booking.foo.Foo;
import com.bjtu.booking.service.OrderService;
import com.bjtu.booking.service.TicketService;

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
	
	@Resource
	private TicketService ticketService;
	
	@Resource
	private OrderService orderService;
	
	/**
	 * Method to get seats map data
	 * @param id area id
	 */
	@RequestMapping("/area")
	public ModelAndView area(@RequestParam("id") int id, @RequestParam("conct") int conctId, ModelMap modelMap){
		ModelAndView view = new ModelAndView();
		
		if(1 == debug){
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Requesting Concert ID [" + conctId + "]");
			System.out.println("Requesting Area ID [" + id + "]");
		}
		
		/**
		 * Seats Map 2-dimension list
		 * Break area tickets into rows for front end use
		 * Each ticket entity should contains ticket id, price and status
		 */
		List<List<Ticket>> seats = ticketService.getTicketByAreaId(id);
		
		if (seats.isEmpty()){
			view.setViewName("error");
			return view;
		}
		
		modelMap.addAttribute("seats", seats);
		modelMap.addAttribute("areaId", id);
		modelMap.addAttribute("concertId", conctId);
		
		view.setViewName("user/seat");
		return view;
	}
	
	/**
	 * Method to generate orders
	 * @param ticket int array, chosen ticket(s) id
	 */
	@RequestMapping("/book")
	public ModelAndView book(@RequestParam("areaid") int areaId,@RequestParam("conctid") int conctId, @RequestParam("ticket") int ticket[], ModelMap modelMap){
		ModelAndView view = new ModelAndView();
		
		if(1 == debug){
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Selected Concert ID [" + conctId + "]");
			System.out.println("Selected Area ID [" + areaId + "]");
		}
		
		Order order = orderService.createOrder(ticket, conctId);
		
		modelMap.addAttribute("preorder", order);
		
		view.setViewName("user/pay");
		return view;
	}
	
	/**
	 * 
	 */
	@RequestMapping("/pay/{id}")
	public ModelAndView pay(@PathVariable("id")int orderId){
		ModelAndView view = new ModelAndView();
		
		if(1 == debug){
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Paying Order ID [" + orderId + "]");
		}
		
		view.setViewName("forward:home");
		return view;
	}
}
