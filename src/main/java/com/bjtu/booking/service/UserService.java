package com.bjtu.booking.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjtu.booking.bean.UserInfo;
import com.bjtu.booking.dao.inf.IUserDAO;

@Service("userService")
public class UserService {
	@Resource
	private IUserDAO userDAO;
	
	public UserInfo getUserById(int id){
		UserInfo user = userDAO.selectById(id);
		return user;
	}
	
	public void updateProfile(UserInfo user) {
		userDAO.updateProfile(user);
	}
}
