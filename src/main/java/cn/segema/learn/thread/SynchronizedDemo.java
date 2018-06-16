package cn.segema.learn.thread;

public class SynchronizedDemo {
	
	
	/**
	 * synchronized(作用域)
	 * 静态对象(全局锁)
	 * SynchronizedDemo sd1 = new SynchronizedDemo();
	 * SynchronizedDemo sd2 = new SynchronizedDemo();
	 * 
	 * 实例对象
	 * SynchronizedDemo sd2 = new SynchronizedDemo();
	 * sd2.test1(); sd2.test2();
	 * 
	 * 代码块
	 */
	
	static Object lock = new Object();
	
	public synchronized String test1() throws InterruptedException {
		lock.wait();
		return "this is test1";
	}
	
	
	public synchronized String test2() {
		return "this is test2";
	}
	
	public static void main(String[] args) {
		
	}
	
}
