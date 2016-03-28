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

@Controller
@RequestMapping("/ticket")
public class BookController {

	@RequestMapping("/area")
	public ModelAndView area(@RequestParam("id") int id, ModelMap modelMap){
		ModelAndView view = new ModelAndView();
		
				List<List<Ticket>> seats = new ArrayList<List<Ticket>>();
		
		if(1 == id){
			for (int i = 0; i < 5; i++) {
				List<Ticket> row = new ArrayList<Ticket>();
				for (int j = 0; j < 4; j++) {
					Ticket seat = new Ticket();
					seat.setId(id * 100 + (i + 1) * 10 + j + 1);
					seat.setPrice(100 * id);
					seat.setStatus(0);
					if (1 == i && 2 == j){
						seat.setStatus(2);
					}
					if (2 == i && 0 == j){
						seat.setStatus(1);
					}
					row.add(seat);
				}
				seats.add(row);
			}
		}
		if(2 == id){
			for (int i = 0; i < 2; i++) {
				List<Ticket> row = new ArrayList<Ticket>();
				for (int j = 0; j < 5; j++) {
					Ticket seat = new Ticket();
					seat.setId(id * 100 + (i + 1) * 10 + j + 1);
					seat.setPrice(100 * id);
					seat.setStatus(2);
					if (1 == i && 2 == j){
						seat.setStatus(0);
					}
					if (0 == i && 4 == j){
						seat.setStatus(0);
					}
					row.add(seat);
				}
				seats.add(row);
			}
		}
		if(3 == id){
			for (int i = 0; i < 6; i++) {
				List<Ticket> row = new ArrayList<Ticket>();
				for (int j = 0; j < 5; j++) {
					Ticket seat = new Ticket();
					seat.setId(id * 100 + (i + 1) * 10 + j + 1);
					seat.setPrice(100 * id);
					seat.setStatus(2);
					if (2 > i){
						seat.setStatus(0);
					}
					row.add(seat);
				}
				seats.add(row);
			}
		}
		if(4 == id){
			for (int i = 0; i < 6; i++) {
				List<Ticket> row = new ArrayList<Ticket>();
				for (int j = 0; j < 2; j++) {
					Ticket seat = new Ticket();
					seat.setId(id * 100 + (i + 1) * 10 + j + 1);
					seat.setPrice(100 * id);
					seat.setStatus(2);
					if (2 < i){
						seat.setStatus(0);
					}
					if (2 == i && 1 == j){
						seat.setStatus(0);
					}
					if (2 == i && 0 == j){
						seat.setStatus(1);
					}
					row.add(seat);
				}
				seats.add(row);
			}
		}
		
		if (seats.isEmpty()){
			view.setViewName("error");
			return view;
		}
		
		modelMap.addAttribute("seats", seats);
		modelMap.addAttribute("areaId", id);
		
		view.setViewName("user/seat");
		return view;
	}
	
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
	
	@RequestMapping("/pay")
	public ModelAndView pay(){
		ModelAndView view = new ModelAndView();
		view.setViewName("");
		return view;
	}
}
