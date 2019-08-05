package cn.segema.learn.interview.design.singleton;

public class MainDemo {

	static SingletonFactoryDemo singletonFactoryDemo = null;

	static SingletonDemo singletonDemo = null;

	public static void main(String[] args) {
		
//		singletonDemo = SingletonDemo.getInstance();
//		SingletonDemo.sayHello("0000");
		
//		singletonFactoryDemo = SingletonFactoryDemo.getInstance();
//		singletonFactoryDemo.sayHello("11111");
		
		
		//
		Singleton singleton = Singleton.getInstance();
		String retStr = singleton.saySingleton("singleton param");
		System.out.println(retStr);
	}

}
