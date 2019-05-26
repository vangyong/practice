package cn.segema.learn.interview.design.singleton;

public class Singleton2 {
	private static class LazyHolder{
		private static final Singleton2 instance = new Singleton2();
	}
	
	private Singleton2() {
		
	}
	
	public static final Singleton2 getInstance() {
		return LazyHolder.instance;
	}

}
