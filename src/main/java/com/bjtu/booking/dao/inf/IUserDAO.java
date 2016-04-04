package com.bjtu.booking.dao.inf;

import org.apache.ibatis.annotations.Param;

import com.bjtu.booking.bean.UserInfo;

public interface IUserDAO {
	
	UserInfo selectById(@Param("id")int id);
	int updateProfile(UserInfo user);
}
