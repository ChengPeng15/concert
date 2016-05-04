package com.bjtu.booking.service;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjtu.booking.bean.Order;
import com.bjtu.booking.bean.OrderDetail;
import com.bjtu.booking.bean.Ticket;
import com.bjtu.booking.dao.inf.IAreaDAO;
import com.bjtu.booking.dao.inf.IConcertDAO;
import com.bjtu.booking.dao.inf.IOrderDAO;
import com.bjtu.booking.dao.inf.ITicketDAO;
import com.bjtu.booking.osb.CustomerType;
import com.bjtu.booking.osb.OrderResponse;
import com.bjtu.booking.osb.OrderType;
import com.bjtu.booking.osb.PlaceOrderProxy;
import com.bjtu.booking.osb.PlaceOrder_PortType;

@Service
public class OrderService {
	
	@Resource
	private IOrderDAO orderDAO;
	
	@Resource
	private ITicketDAO ticketDAO;
	
	@Resource
	private IAreaDAO areaDAO;
	
	@Resource
	private IConcertDAO concertDAO;
	
	public Order createOrder(int[] tickets, int concertId){
		
		Order order = new Order();
		//lock tickets
		ticketDAO.bookTickets(tickets);
		
		//create order
		//TODO set the user id
		order.setUserId(3);
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
			detail.setTicket(ticket);
			details.add(detail);
		}
		orderDAO.creatOrderDetails(details);
		
		order.setDetail(details);
		return order;
	}
	
	public boolean payOrder(int orderId, String ccNumber) {
		Order order = orderDAO.getOrderById(orderId);
		PlaceOrderProxy proxy = new PlaceOrderProxy("http://localhost:7001/Order-Messaging-Service/proxy/PlaceOrder?wsdl");
		PlaceOrder_PortType service = proxy.getPlaceOrder_PortType();
		OrderType orderType = new OrderType();
		orderType.setOrderID(order.getId());
		orderType.setOrderDate(order.getCreateTime());
		orderType.setOrderStatus(String.valueOf(order.getStatus()));
		orderType.setOrderTotal(String.valueOf(order.gettPrice()));
		CustomerType customer = new CustomerType();
		customer.setEmail(order.getUser().getEmail());
		customer.setName(order.getUser().getName());
		customer.setShippingAddress(order.getUser().getAddress());
		customer.setCCnumber(ccNumber);
		orderType.setCustomer(customer);
		
		try {
			OrderResponse resp = service.setOrder(orderType);
			if("valid".equalsIgnoreCase(resp.getStatus())){
				int[] tickets = new int[order.getDetail().size()];
				int i = 0;
				for(OrderDetail detail : order.getDetail()){
					tickets[i++] = detail.getTicketId();
					areaDAO.sellTicket(detail.getTicket().getAreaId());
				}
				ticketDAO.sellTickets(tickets);
				concertDAO.updateSoldSeat(tickets.length, order.getConcertId());
				orderDAO.payOrder(order.getId());
				System.out.println("Order has been processed successfully");
				return true;
			} else {
				System.out.println("Process Order failed!!!");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<Order> getUserOrders(int userId){
		return orderDAO.getAllOrder();
	}
	
	public Order getOrderDetail(int orderId){
		return orderDAO.getOrderById(orderId);
	}
}
