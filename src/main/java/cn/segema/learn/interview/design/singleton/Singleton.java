package cn.segema.learn.interview.design.singleton;

public class Singleton {
	// 懒汉、线程不安全
//	private static Singleton instance;
//
//	private Singleton() {
//	}
//
//	public static Singleton getInstance() {
//		if (instance == null) {
//			instance = new Singleton();
//		}
//		return instance;
//	}

	// 懒汉、线程安全
//	private static Singleton instance;
//
//	private Singleton() {
//	}
//
//	public static synchronized Singleton getInstance() {
//		if (instance == null) {
//			instance = new Singleton();
//		}
//		return instance;
//	}

	// 饿汉
//	private static Singleton instance = new Singleton();
//
//	private Singleton() {
//	}
//
//	public static Singleton getInstance() {
//		return instance;
//	}

	// 饿汉，变种
//	private Singleton instance = null;
//	static {
//		instance = new Singleton();
//	}
//
//	private Singleton() {
//	}
//
//	public static Singleton getInstance() {
//		return this.instance;
//	}

	// 静态内部类
//	private static class SingletonHolder {
//		private static final Singleton INSTANCE = new Singleton();
//	}
//
//	private Singleton() {
//	}
//
//	public static final Singleton getInstance() {
//		return SingletonHolder.INSTANCE;
//	}

	// 双重校验锁
	private volatile static Singleton singleton;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
	
	
	//业务逻辑方法
	public static String saySingleton(String param) {
		System.out.println(param);
		return "saySingleton";
	}

}
