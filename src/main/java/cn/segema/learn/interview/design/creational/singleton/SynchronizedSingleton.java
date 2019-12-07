package cn.segema.learn.interview.design.creational.singleton;

public class SynchronizedSingleton {

	private static SynchronizedSingleton instance = null;

	private SynchronizedSingleton() {
	}

	private static synchronized void syncInit() {
		if (instance == null) {
			instance = new SynchronizedSingleton();
		}
	}

	public static SynchronizedSingleton getInstance() {
		if (instance == null) {
			syncInit();
		}
		return instance;
	}
	
	
	//业务逻辑方法
	public String sayHello(String param) {
		System.out.println(param);
		System.out.println("SynchronizedSingleton");
		return "sayHello";
	}

}
