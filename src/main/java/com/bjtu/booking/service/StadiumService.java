package com.bjtu.booking.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjtu.booking.bean.Stadium;
import com.bjtu.booking.dao.inf.IStadiumDAO;

@Service
public class StadiumService {
	
	@Resource
	private IStadiumDAO stadiumDAO;
	
	public List<Stadium> getStadiumList(){
		return stadiumDAO.getStadiumList();
	}
	
	public List<Stadium> getTop3Stadium(){
		return stadiumDAO.getTop3Stadium();
	}
}
