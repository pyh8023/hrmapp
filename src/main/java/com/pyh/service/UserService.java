package com.pyh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyh.dao.UserDao;
import com.pyh.domain.User;

@Service("userService")
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User findUserById(int id) {
		return userDao.selectById(id);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
