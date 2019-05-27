package cn.segema.learn.interview.concurrent.synchronize;

/**
 * 作用域
 * 全局锁
 * 实例对象
 * 
 * 
 * 代码块
 * 
 * 
 * @author wangyong
 *
 */
public class Demo {
	
	
	
	
	public static void main(String[] args) {
		//Sync sync = new Sync();  
		for (int i = 0; i < 3; i++) {
			Thread thread = new MyThread();
			thread.start();
		}
	}
}
