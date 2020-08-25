package cn.segema.learn.interview.designmode.creational.singleton;

/**
 * @description 静态内部类单例
 * @author wangyong
 * @createDate 2020/05/11
 */
public class StaticInnerSingleton {
	// 静态内部类
	private static class SingletonHolder {
		private static final StaticInnerSingleton instance = new StaticInnerSingleton();
	}

	private StaticInnerSingleton() {
	}

	public static final StaticInnerSingleton getInstance() {
		return SingletonHolder.instance;
	}
	
	//业务逻辑方法
	public String sayHello(String param) {
		System.out.println(param);
		System.out.println("StaticInnerSingleton");
		return "sayHello";
	}

}
