package cn.segema.learn.interview.design.singleton;

public class SingletonFactoryDemo {

	/* 私有构造方法，防止被实例化 */
	private SingletonFactoryDemo() {
	}

	/* 此处使用一个内部类来维护单例 */
	private static class SingletonFactory {
		private static SingletonFactoryDemo instance = new SingletonFactoryDemo();
	}

	/* 获取实例 */
	public static SingletonFactoryDemo getInstance() {
		return SingletonFactory.instance;
	}

	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
	public Object readResolve() {
		return getInstance();
	}
	
	public  static String sayHello(String param) {
		System.out.println(param);
		return "sayHello";
	}
	
}
