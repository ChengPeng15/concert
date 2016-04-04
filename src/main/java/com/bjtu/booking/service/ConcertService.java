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
		if(null != list) {
			System.out.println("result is not null");
			for(Concert c : list) {
				System.out.println(c.getTitle());
				System.out.println(c.getStadiumName() + "======");
			}
		}
		return null;
	}
}
