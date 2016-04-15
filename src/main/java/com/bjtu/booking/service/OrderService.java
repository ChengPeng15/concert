package com.bjtu.booking.service;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjtu.booking.bean.Order;
import com.bjtu.booking.bean.OrderDetail;
import com.bjtu.booking.bean.Ticket;
import com.bjtu.booking.dao.inf.IOrderDAO;
import com.bjtu.booking.dao.inf.ITicketDAO;

@Service
public class OrderService {
	
	@Resource
	private IOrderDAO orderDAO;
	
	@Resource
	private ITicketDAO ticketDAO;
	
	public Order createOrder(int[] tickets){
		
		Order order = new Order();
		//update ticket status
		ticketDAO.bookTickets(tickets);
		//create order
		order.setUserId(2);
		//TODO set the concert id
		order.setConcertId(2);
		double totalPrice = ticketDAO.getTotalPrice(tickets);
		order.settPrice(totalPrice);
		order.setStatus(0);
		order.setCreateTime(new Timestamp(System.currentTimeMillis()));
		orderDAO.createOrder(order);
		
		//create order_info
		for(int t : tickets){
			Ticket ticket = ticketDAO.getTicketById(t);
			OrderDetail detail =  new OrderDetail();
			detail.setOrderId(order.getId());
			detail.setTicketId(t);
			detail.setFinalPrice(ticket.getPrice());
			detail.setOriginalPrice(ticket.getPrice());
			
		}
		return order;
	}
}
