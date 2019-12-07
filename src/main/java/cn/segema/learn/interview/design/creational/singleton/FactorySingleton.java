package cn.segema.learn.interview.design.creational.singleton;

public class FactorySingleton {

	/* 私有构造方法，防止被实例化 */
	private FactorySingleton() {
	}

	/* 此处使用一个内部类来维护单例 */
	private static class Factory {
		private static FactorySingleton instance = new FactorySingleton();
	}

	/* 获取实例 */
	public static FactorySingleton getInstance() {
		return Factory.instance;
	}

	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
	public Object readResolve() {
		return getInstance();
	}

	public String sayHello(String param) {
		System.out.println(param);
		System.out.println("this is FactorySingleton!");
		return "sayHello";
	}

}
