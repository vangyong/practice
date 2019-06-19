package cn.segema.learn.interview.design.singleton;

public class MainDemo {

	static SingletonFactoryDemo singletonFactoryDemo = null;

	static SingletonDemo SingletonDemo = null;

	public static void main(String[] args) {

	}

	public static void test1() {
		SingletonDemo = SingletonDemo.getInstance();
		SingletonDemo.sayHello("0000");
		singletonFactoryDemo = SingletonFactoryDemo.getInstance();
		singletonFactoryDemo.sayHello("11111");
	}

}
