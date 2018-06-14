package cn.segema.learn.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	public String test1() {
		Lock lock = new ReentrantLock();
		try {
			
			Thread thread1 = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("this is thread1");
				}
			});
			
			thread1.interrupt();
			
			//lock.lock();
			lock.lockInterruptibly();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		return "test1";
	}
	
	
	
			
			
}
