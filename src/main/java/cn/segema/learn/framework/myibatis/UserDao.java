package cn.segema.learn.framework.myibatis;

import java.util.List;

public interface UserDao {
	
	public int insertUser(int age,String name);
	
	public List<User> selectUserList(User user);

}
