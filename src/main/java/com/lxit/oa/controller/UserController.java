package com.lxit.oa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxit.oa.beans.User;
import com.lxit.oa.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@RequestMapping("/testUser")
	public String selectBasis(){
		System.out.println("controller==========="+userService);
		List<User> users = userService.selectAllUser();
		System.out.println("users:::"+users);
		return "test";
	}
	
}
