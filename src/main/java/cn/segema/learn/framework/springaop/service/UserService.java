package cn.segema.learn.framework.springaop.service;

import cn.segema.learn.framework.springaop.domain.User;

public class UserService {
	
	public User createUser(String userName) {
		User user = new User();
		user.setUserName(userName);
		user.setAge(10);
		return user;
	}
}
