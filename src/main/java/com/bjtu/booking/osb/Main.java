package com.bjtu.booking.osb;

import java.util.Date;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PlaceOrderProxy proxy = new PlaceOrderProxy("http://localhost:7001/Order-Messaging-Service/proxy/PlaceOrder?wsdl");
		PlaceOrder_PortType service = proxy.getPlaceOrder_PortType();
		OrderType order = new OrderType();
		order.setOrderID(9955999888L);
		order.setOrderDate(new Date());
		order.setOrderStatus("initialize");
		order.setOrderTotal("2000");
		CustomerType customer = new CustomerType();
		customer.setEmail("osbuser@localhost");
		customer.setName("kevinj");
		customer.setShippingAddress("beijing");
		customer.setCCnumber("88886666");
		order.setCustomer(customer);
		OrderResponse resp = service.setOrder(order);
		System.out.println(resp.getStatus());
	}

}
