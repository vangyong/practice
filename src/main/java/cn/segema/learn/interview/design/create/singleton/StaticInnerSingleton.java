package cn.segema.learn.interview.design.create.singleton;

public class StaticInnerSingleton {
	// 静态内部类
	private static class SingletonHolder {
		private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
	}

	private StaticInnerSingleton() {
	}

	public static final StaticInnerSingleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
	//业务逻辑方法
	public String sayHello(String param) {
		System.out.println(param);
		System.out.println("StaticInnerSingleton");
		return "sayHello";
	}

}
