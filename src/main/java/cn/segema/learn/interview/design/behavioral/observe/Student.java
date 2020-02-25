package cn.segema.learn.interview.design.behavioral.observe;

public class Student implements Observer {

	private String name;

	@Override
	public void update(String message) {
		System.out.println("主题状态消息:" + message + "," + name + "到");
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
