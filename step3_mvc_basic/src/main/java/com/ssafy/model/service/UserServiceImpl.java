package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDAO userDao;
	
	@Autowired
	public UserServiceImpl(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public String login(Map<String, String> user) throws SQLException {
		return userDao.login(user);
	}
}
