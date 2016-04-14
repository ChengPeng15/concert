package com.bjtu.booking.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bjtu.booking.bean.Ticket;
import com.bjtu.booking.dao.inf.ITicketDAO;

public class TicketService {
	
	@Resource
	private ITicketDAO ticketDAO;
	
	public List<List<Ticket>> getTicketByAreaId(int id){
		List<List<Ticket>> result = new ArrayList<List<Ticket>>();
		List<Ticket> linearSeats = ticketDAO.getTicketByArea(id);
		int tmpY = -1;
		if(null != linearSeats) {
			List<Ticket> row = null;
			for(Ticket ticket : linearSeats){
				if(tmpY != ticket.getYValue()){
					if(null != row) {
						result.add(row);
					}
					tmpY = ticket.getYValue();
					row = new ArrayList<Ticket>();
				}
				if(null != row) {
					row.add(ticket);
				}
			}
		}
		return result;
	}

}
