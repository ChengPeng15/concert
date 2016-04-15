package com.bjtu.booking.dao.inf;

import java.util.List;

import com.bjtu.booking.bean.Ticket;

public interface ITicketDAO {
	List<Ticket> getTicketByArea(int id);
	double getTotalPrice(int[] tickets);
	int bookTickets(int[] tickets);
	Ticket getTicketById(int id);
}
