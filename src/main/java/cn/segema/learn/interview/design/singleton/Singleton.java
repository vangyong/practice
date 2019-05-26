package cn.segema.learn.interview.design.singleton;

public class Singleton {
	private Singleton() {
		
	}
	
	private static Singleton instance = null;
	//静态方法
	public static Singleton getInstance() {
		if(instance==null) {
			synchronized (Singleton.class) {
				if(instance==null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
