package cn.segema.learn.interview.design.singleton;

//懒汉式单例类
public class SingletonDemo {

	/* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
	private static SingletonDemo instance = null;

	/* 私有构造方法，防止被实例化 */
	private SingletonDemo() {
	}

	/* 静态工程方法，创建实例 */
	public static SingletonDemo getInstance() {
		if (instance == null) {
			synchronized (instance) {
				if (instance == null) {
					instance = new SingletonDemo();
				}
			}
		}
		return instance;
	}

	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
	public Object readResolve() {
		return instance;
	}

	public static String sayHello(String param) {
		System.out.println(param);
		return "sayHello";
	}

}
