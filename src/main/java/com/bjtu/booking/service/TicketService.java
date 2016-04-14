package com.bjtu.booking.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjtu.booking.bean.Ticket;
import com.bjtu.booking.dao.inf.ITicketDAO;

@Service
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
					tmpY = ticket.getYValue();
					row = new ArrayList<Ticket>();
					result.add(row);
				}
				if(null != row) {
					row.add(ticket);
				}
			}
		}
		return result;
	}

}
