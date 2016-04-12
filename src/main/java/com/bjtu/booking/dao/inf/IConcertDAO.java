package com.bjtu.booking.dao.inf;

import java.util.List;

import com.bjtu.booking.bean.Concert;

public interface IConcertDAO {
	
	List<Concert> getConcertList();
	List<Concert> getLatest3Concert();
	Concert getConcertById(int id);
}
