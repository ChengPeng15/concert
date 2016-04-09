package com.bjtu.booking.dao.inf;

import java.util.List;

import com.bjtu.booking.bean.Stadium;

public interface IStadiumDAO {
	List<Stadium> getStadiumList();
	List<Stadium> getTop3Stadium();
}
