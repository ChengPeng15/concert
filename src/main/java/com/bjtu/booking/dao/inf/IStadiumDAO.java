package com.bjtu.booking.dao.inf;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bjtu.booking.bean.Stadium;

public interface IStadiumDAO {
	List<Stadium> getStadiumList();
	List<Stadium> getTop3Stadium();
	Stadium getStadiumById(@Param("id")int id, @Param("current") Date date);
}
