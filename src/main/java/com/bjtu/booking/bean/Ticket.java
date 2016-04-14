package com.bjtu.booking.bean;

import java.io.Serializable;

public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String code;
	private int xValue;
	private int yValue;
	private double price;
	private int areaId;
	private String areaName; // for front end use
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getXValue() {
		return xValue;
	}

	public void setXvalue(int xValue) {
		this.xValue = xValue;
	}

	public int getYValue() {
		return yValue;
	}

	public void setYValue(int yValue) {
		this.yValue = yValue;
	}

}
