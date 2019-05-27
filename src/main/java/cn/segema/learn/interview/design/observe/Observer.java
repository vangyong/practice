package cn.segema.learn.interview.design.observe;

public interface Observer {
	
	//更新自己
	  void update(String message);

	  //这里用于区分每个观察者，根据实际需求
	  void setName(String name);

}
