package com.naimur.spring.web.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naimur.spring.web.dao.User;
import com.naimur.spring.web.dao.UserDao;

@Service("userService")
public class UserService {
	
	private UserDao userDao;

   
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	

	public void create(@Valid User user) {
		userDao.create(user);
		
	}



	public boolean exists(String username) {
		
		return userDao.exists(username);
	}



	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	

}
