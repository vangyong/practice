package cn.segema.learn.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TraditionanlThread2 {

	public static void main(String[] args) {
		
		Thread thread = new Thread("线程1") {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName());
				}
			}
		};
		thread.start();
		thread.run();
		
		
		
		
		
		
		
	}

}
