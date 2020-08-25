package cn.segema.learn.interview.designmode.creational.singleton;

/**
 * @description 双重校验单例
 * @author wangyong
 * @createDate 2020/08/25
 */
public class DoubleCheckSingleton {
	// 双重校验锁
	private volatile static DoubleCheckSingleton singleton;

	private DoubleCheckSingleton() {
	}

	public static DoubleCheckSingleton getInstance() {
		if (singleton == null) {
			synchronized (DoubleCheckSingleton.class) {
				if (singleton == null) {
					singleton = new DoubleCheckSingleton();
				}
			}
		}
		return singleton;
	}

	// 业务逻辑方法
	public static String saySingleton(String param) {
		System.out.println(param);
		System.out.println("DoubleCheckSingleton");
		return "saySingleton";
	}

}
