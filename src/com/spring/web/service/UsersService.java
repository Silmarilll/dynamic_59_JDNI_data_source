package com.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.dao.User;
import com.spring.web.dao.UsersDAO;

@Service("usersService")
public class UsersService {
	
	private UsersDAO usersDao;
	
	@Autowired
	public void setUsersDao(UsersDAO usersDao) {
		this.usersDao = usersDao;
	}


	public void create(User user) {
		usersDao.create(user);
	}
}
