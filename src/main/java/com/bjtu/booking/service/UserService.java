package com.bjtu.booking.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjtu.booking.bean.UserInfo;
import com.bjtu.booking.dao.inf.IUserDAO;

@Service("userService")
public class UserService {
	@Resource
	private IUserDAO userDAO;
	
	public void getUserById(int id){
		UserInfo user = userDAO.selectById(1, "admin");
		System.out.println(user == null);
	}
}
