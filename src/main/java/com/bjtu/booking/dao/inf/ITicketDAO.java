package com.bjtu.booking.dao.inf;

import java.util.List;

import com.bjtu.booking.bean.Ticket;

public interface ITicketDAO {
	List<Ticket> getTicketByArea(int id);
}
