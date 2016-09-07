package com.xlinyu.user.service.impl;

import org.apache.log4j.Logger;

import com.xlinyu.user.service.IUserService;

public class UserService implements IUserService {

	private static final Logger logger = Logger.getLogger(UserService.class);
	
	@Override
	public String sayHello(String name) {
		logger.info("name: " + name);
		return "Hello " + name;
	}

}
