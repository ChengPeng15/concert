package com.bjtu.booking.dao.inf;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bjtu.booking.bean.Concert;

public interface IConcertDAO {
	
	List<Concert> getConcertList(@Param("current") Date date);
	List<Concert> getLatest3Concert(@Param("current") Date date);
	Concert getConcertById(int id);
}
