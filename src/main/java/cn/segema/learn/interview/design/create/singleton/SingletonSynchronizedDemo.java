package cn.segema.learn.interview.design.create.singleton;

public class SingletonSynchronizedDemo {

	private static SingletonSynchronizedDemo instance = null;

	private SingletonSynchronizedDemo() {
	}

	private static synchronized void syncInit() {
		if (instance == null) {
			instance = new SingletonSynchronizedDemo();
		}
	}

	public static SingletonSynchronizedDemo getInstance() {
		if (instance == null) {
			syncInit();
		}
		return instance;
	}

}
