package com.bjtu.booking.dao.inf;

import java.util.List;

import com.bjtu.booking.bean.Order;
import com.bjtu.booking.bean.OrderDetail;

public interface IOrderDAO {
	int createOrder(Order order);
	int creatOrderDetails(List<OrderDetail> details);
}
