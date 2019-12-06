package cn.segema.learn.interview.design.create.singleton;

public class HungrySingleton {
	// 饿汉，变种
	private static HungrySingleton instance = null;
	static {
		instance = new HungrySingleton();
	}

	private HungrySingleton() {
	}

	public static HungrySingleton getInstance() {
		return instance;
	}
	
	public String sayHello(String param) {
		System.out.println("param:"+param);
		System.out.println("this is HungrySingleton!");
		return "sayHello";
	}

}
