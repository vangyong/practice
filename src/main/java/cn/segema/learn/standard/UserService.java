package cn.segema.learn.standard;

import java.util.List;

public interface UserService {
	
	long a =2L;
	
	
	String COMPANY = "alibaba";
	

	String sayHello();
	
	default String getUserName() {
		return null;
	}
	default List<String> listUserName(){
		return null;
	}
	
	
	//xxxDO
	//xxxDTO
	//xxxVO
	//POJO 是DO DTO VO的统称
	
	
	
	
	
	
	
}
