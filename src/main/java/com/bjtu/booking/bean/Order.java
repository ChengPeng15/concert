package com.bjtu.booking.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private int userId;
	private int concertId;
	private String concertName;
	private double tPrice;
	private int status;
	private Timestamp createTime;
	private Timestamp payTime;
	private List<OrderDetail> detail;
	private int detailNum;
	private UserInfo user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getConcertId() {
		return concertId;
	}

	public void setConcertId(int concertId) {
		this.concertId = concertId;
	}

	public String getConcertName() {
		return concertName;
	}

	public void setConcertName(String concertName) {
		this.concertName = concertName;
	}

	public double gettPrice() {
		return tPrice;
	}

	public void settPrice(double tPrice) {
		this.tPrice = tPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getPayTime() {
		return payTime;
	}

	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}

	public List<OrderDetail> getDetail() {
		return detail;
	}

	public void setDetail(List<OrderDetail> detail) {
		this.detail = detail;
	}

	public int getDetailNum() {
		return detailNum;
	}

	public void setDetailNum(int detailNum) {
		this.detailNum = detailNum;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
}
