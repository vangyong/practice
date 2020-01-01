package cn.segema.learn.framework.springaop.controller;

import cn.segema.learn.framework.springaop.domain.User;
import cn.segema.learn.framework.springaop.service.UserService;

public class UserController {
	
	public User addUser(String userName) {
		UserService userService = new UserService();
		User user = userService.createUser(userName);
		return user;
	}

}
