package com.xlinyu.user.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.xlinyu.user.dao.UserDao;
import com.xlinyu.user.model.User;
import com.xlinyu.user.service.IUserService;

public class UserService implements IUserService {

	private static final Logger logger = Logger.getLogger(UserService.class);
	
	@Resource
	private UserDao userDao;
	
	@Override
	public String sayHello(String name) {
		logger.info("name: " + name);
		System.out.println("Hi Hudson success... need export java env");
		return "Hello---> from hudson " + name;
	}

	@Override
	public User findOne(String id) {
		logger.info("id: " + id);
		return userDao.findOne(id);
	}
}
