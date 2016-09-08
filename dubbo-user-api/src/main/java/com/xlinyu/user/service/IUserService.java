package com.xlinyu.user.service;

import com.xlinyu.user.model.User;

public interface IUserService {

	public String sayHello(String name);
	
	public User findOne(String id);
	
}
