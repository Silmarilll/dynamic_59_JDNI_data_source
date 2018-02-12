package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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


	public boolean create(User user) {
		return usersDao.create(user);
	}


	public boolean exists(String username) {
		return usersDao.exists(username);
	}

	@Secured(value="ROLE_ADMIN")
	public List<User> getAllUsers() {
		return usersDao.getAllUsers();
	}
}
