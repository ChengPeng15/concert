package com.bjtu.booking.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjtu.booking.bean.Concert;
import com.bjtu.booking.dao.inf.IConcertDAO;

@Service
public class ConcertService {
	
	@Resource
	private IConcertDAO concertDAO;
	
	public List<Concert> getConcertList(){
		List<Concert> list = concertDAO.getConcertList();
		return list;
	}
	
	public List<Concert> getLatest3Concert(){
		return concertDAO.getLatest3Concert();
	}
	
	public Concert getConcertById(int id){
		return concertDAO.getConcertById(id);
	}
}
