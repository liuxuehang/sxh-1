package com.lxit.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxit.oa.beans.User;
import com.lxit.oa.dao.UserDao;
import com.lxit.oa.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDao;
	
	@Override
	public List<User> selectAllUser() {
		System.out.println("service~~~~~~~~~~~~");
		return userDao.selectAllUser();
	}
	
}
