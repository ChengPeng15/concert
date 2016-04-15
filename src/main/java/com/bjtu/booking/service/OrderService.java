package com.bjtu.booking.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
	
	public Order createOrder(int[] tickets, int concertId){
		
		Order order = new Order();
		//lock tickets
		ticketDAO.bookTickets(tickets);
		
		//create order
		//TODO set the user id
//		order.setUserId(2);
		order.setConcertId(concertId);
		double totalPrice = ticketDAO.getTotalPrice(tickets);
		order.settPrice(totalPrice);
		order.setStatus(0);
		order.setCreateTime(new Timestamp(System.currentTimeMillis()));
		orderDAO.createOrder(order);
		
		//create order_info
		List<OrderDetail> details = new ArrayList<OrderDetail>();
		for(int t : tickets){
			Ticket ticket = ticketDAO.getTicketById(t);
			OrderDetail detail =  new OrderDetail();
			detail.setOrderId(order.getId());
			detail.setTicketId(t);
			detail.setFinalPrice(ticket.getPrice());
			detail.setOriginalPrice(ticket.getPrice());
			details.add(detail);
		}
		orderDAO.creatOrderDetails(details);
		
		order.setDetail(details);
		return orderDAO.getOrderById(order.getId());
	}
}
