package com.bjtu.booking.foo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjtu.booking.bean.Area;
import com.bjtu.booking.bean.Concert;
import com.bjtu.booking.bean.Order;
import com.bjtu.booking.bean.OrderDetail;
import com.bjtu.booking.bean.Stadium;
import com.bjtu.booking.bean.Ticket;
import com.bjtu.booking.bean.UserInfo;

/**
 * All methods here are purely rubbish but references, need replace by some real
 * thing.
 * 
 * @author SHAO
 *
 */
public class Foo {

	// Concert
	public List<Concert> getConcertList() {
		List<Concert> list = new ArrayList<Concert>();

		for (int i = 1; i < 4; i++) {
			Concert conct = new Concert();
			conct.setId(i);
			conct.setTitle("Concert " + i);
			conct.setOpen(new Timestamp((new Date()).getTime()));
			conct.setEnd(new Timestamp((new Date()).getTime()));
			conct.setStadiumId(i);
			conct.setStadiumName("Stadium " + i);
			conct.setTotal(100);
			conct.setSold((int) (Math.random() * 100 + 1));
			list.add(conct);
		}

		return list;
	}

	public List<Area> getConcertArea(int id) {
		List<Area> list = new ArrayList<Area>();

		if (1 == id) {
			Area area1 = new Area();
			area1.setId(1);
			area1.setName("East");
			area1.setTotal(20);
			area1.setSold(1);
			list.add(area1);
			Area area2 = new Area();
			area2.setId(2);
			area2.setName("West");
			area2.setTotal(10);
			area2.setSold(8);
			list.add(area2);
		}
		if (2 == id) {
			Area area1 = new Area();
			area1.setId(3);
			area1.setName("North");
			area1.setTotal(30);
			area1.setSold(10);
			list.add(area1);
			Area area2 = new Area();
			area2.setId(4);
			area2.setName("South");
			area2.setTotal(12);
			area2.setSold(5);
			list.add(area2);
		}

		return list;
	}

	public Concert getConcertDetail(int id) {
		Concert conct = new Concert();

		conct.setAreas(this.getConcertArea(id));
		conct.setId(id);
		conct.setOpen(new Timestamp((new Date()).getTime()));
		conct.setEnd(new Timestamp((new Date()).getTime()));
		conct.setTitle("Concert " + id);
		conct.setIntro("Concert " + id + " will be a great success.");
		conct.setStadiumName("Stadium " + id);
		conct.setTotal(18 + id * 12);
		conct.setSold(3 + id * 6);

		return conct;
	}

	// Seatmap
	public List<List<Ticket>> getSeatMap(int id) {
		List<List<Ticket>> seats = new ArrayList<List<Ticket>>();

		if (1 == id) {
			for (int i = 0; i < 5; i++) {
				List<Ticket> row = new ArrayList<Ticket>();
				for (int j = 0; j < 4; j++) {
					Ticket seat = new Ticket();
					seat.setId(id * 100 + (i + 1) * 10 + j + 1);
					seat.setPrice(100 * id);
					seat.setStatus(0);
					if (1 == i && 2 == j) {
						seat.setStatus(2);
					}
					if (2 == i && 0 == j) {
						seat.setStatus(1);
					}
					row.add(seat);
				}
				seats.add(row);
			}
		}
		if (2 == id) {
			for (int i = 0; i < 2; i++) {
				List<Ticket> row = new ArrayList<Ticket>();
				for (int j = 0; j < 5; j++) {
					Ticket seat = new Ticket();
					seat.setId(id * 100 + (i + 1) * 10 + j + 1);
					seat.setPrice(100 * id);
					seat.setStatus(2);
					if (1 == i && 2 == j) {
						seat.setStatus(0);
					}
					if (0 == i && 4 == j) {
						seat.setStatus(0);
					}
					row.add(seat);
				}
				seats.add(row);
			}
		}
		if (3 == id) {
			for (int i = 0; i < 6; i++) {
				List<Ticket> row = new ArrayList<Ticket>();
				for (int j = 0; j < 5; j++) {
					Ticket seat = new Ticket();
					seat.setId(id * 100 + (i + 1) * 10 + j + 1);
					seat.setPrice(100 * id);
					seat.setStatus(2);
					if (2 > i) {
						seat.setStatus(0);
					}
					row.add(seat);
				}
				seats.add(row);
			}
		}
		if (4 == id) {
			for (int i = 0; i < 6; i++) {
				List<Ticket> row = new ArrayList<Ticket>();
				for (int j = 0; j < 2; j++) {
					Ticket seat = new Ticket();
					seat.setId(id * 100 + (i + 1) * 10 + j + 1);
					seat.setPrice(100 * id);
					seat.setStatus(2);
					if (2 < i) {
						seat.setStatus(0);
					}
					if (2 == i && 1 == j) {
						seat.setStatus(0);
					}
					if (2 == i && 0 == j) {
						seat.setStatus(1);
					}
					row.add(seat);
				}
				seats.add(row);
			}
		}

		return seats;
	}

	// Stadium
	public List<Stadium> getStadiumList() {
		List<Stadium> list = new ArrayList<Stadium>();

		for (int i = 1; i < 4; i++) {
			Stadium stadm = new Stadium();

			stadm.setId(i);
			stadm.setName("Stadium " + i);
			stadm.setTotal(200);
			stadm.setAddress("Some where on this planet");

			list.add(stadm);
		}

		return list;
	}

	public List<Concert> getStadiumConcert(int id) {
		List<Concert> list = new ArrayList<Concert>();

		for (int i = 1; i < 3; i++) {
			Concert conct = new Concert();
			conct = this.getConcertDetail(i);
			list.add(conct);
		}

		return list;
	}

	public Stadium getStadiumDetail(int id) {
		Stadium stadm = new Stadium();

		stadm.setId(id);
		stadm.setName("Stadium " + id);
		stadm.setIntro("This is a big stadium");
		stadm.setTotal(200);
		stadm.setAddress("Some where on this planet");
		if (1 == id) {
			stadm.setConcerts(this.getStadiumConcert(id));
		}

		return stadm;
	}

	// user
	public UserInfo getUserInfo(int id) {
		UserInfo user = new UserInfo();
		
		user.setId(id);
		user.setName("User " + id);
		user.setEmail("user@whatever.com");
		user.setMobile("13800138000");
		user.setAddress("Whatever HQ");
		user.setRole(0);
		
		return user;
	}
	
	public List<Order> getUserOrder(int id){
		List<Order> list = new ArrayList<Order>();
		
		for (int i = 1; i < 4; i++) {
			Order order = new Order();
			order.setId(i);
			order.setConcertName("Concert " + i);
			order.setCreateTime(new Timestamp((new Date()).getTime()));
			if(2 == i){
				order.setPayTime(new Timestamp((new Date()).getTime()));
			}
			order.setDetailNum(i);
			order.settPrice(i*200);
			order.setStatus(i - 1);
			list.add(order);
		}
		
		return list;
	}

	public List<OrderDetail> getOrderDetail(int id){
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		
		for (int i = 1; i <= id; i++) {
			OrderDetail detail = new OrderDetail();
			detail.setId(id * 10 + i);
			detail.setOriginalPrice(id * 100);
			detail.setFinalPrice(id * 100);
			detail.setTicket(this.getTicket(i));
			list.add(detail);
		}
		
		return list;
	}
	
	public Order getOrder(int id){
		Order order = new Order();

		order.setId(id);
		order.setConcertId(id);
		order.setConcertName("Concert " + id);
		order.setCreateTime(new Timestamp((new Date()).getTime()));
		if(2 == id){
			order.setPayTime(new Timestamp((new Date()).getTime()));
		}
		order.setDetail(this.getOrderDetail(id));
		order.settPrice(id * 200);
		order.setStatus(id - 1);
		
		return order;
	}
	
	//Ticket
	public Ticket getTicket(int id){
		Ticket ticket = new Ticket();
		
		ticket.setAreaName("Area " + id);
		ticket.setCode(id * 100 + id);
		
		return ticket;
	}
}