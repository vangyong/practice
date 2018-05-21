package cn.segema.learn.interview.base;

public class Singleton {
	private static Singleton instance;
	
	private Singleton() {
		System.out.println("单例模式");
	}
	
	private static synchronized Singleton getInstance() {
		if(instance==null) {
			instance = new Singleton();
		}
		return instance;
	}
	

}
