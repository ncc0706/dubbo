package com.xlinyu.user.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xlinyu.user.model.User;

public interface UserDao {

	@Select("select * from user where id=#{id}")
	public User findOne(@Param("id") String id);
	
}
