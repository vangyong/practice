package cn.segema.learn.framework.myibatis;

import java.util.List;

public class UserMyibatisDemo {
	public static void main(String[] args) {
		UserDao mapper;
		try {
			mapper = SqlSession.getMapper(UserDao.class);
			int insertUser = mapper.insertUser(22, "小盒子");
			System.out.println("影响行数:" + insertUser);
			
			User userParam = new User(1,"Xiaoxin",21);
			List<User> userList = mapper.selectUserList(userParam);
			if(userList!=null&& userList.size()>0) {
				for(User user:userList) {
					System.out.println("查询结果:" + user.getName() + "," + user.getAge());
				}
			}
		} catch (IllegalArgumentException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
