package com.bjtu.booking.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Concert implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private int stadiumId;
	private String stadiumName; // for front end use
	private String title;
	private String intro;
	private Timestamp open;
	private Timestamp end;
	private int total;
	private int sold;
	private List<Area> areas; // for front end use

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStadiumId() {
		return stadiumId;
	}

	public void setStadiumId(int stadiumId) {
		this.stadiumId = stadiumId;
	}

	public String getStadiumName() {
		return stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Timestamp getOpen() {
		return open;
	}

	public void setOpen(Timestamp open) {
		this.open = open;
	}

	public Timestamp getEnd() {
		return end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

}
