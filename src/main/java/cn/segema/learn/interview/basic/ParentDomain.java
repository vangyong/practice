package cn.segema.learn.interview.basic;

public class ParentDomain {

	public ParentDomain(String name) {
		this.name = name;
	}

	public String name;

	public String sayHello() {
		return "hello my name " + name;
	}

}
