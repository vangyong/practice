package cn.segema.learn.framework.myibatis;

import java.util.List;

public interface UserDao {
	@ExtInsert(value="insert into user values(#{age},#{name})")
	public int insertUser(@ExtParam("age") int age,@ExtParam("name") String name);
	
	public List<User> selectUserList(User user);

}
