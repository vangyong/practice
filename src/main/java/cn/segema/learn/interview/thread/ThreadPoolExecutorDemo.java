package cn.segema.learn.interview.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorDemo {
	public static void main(String[] args) {
		// 创建线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(10);

		while (true) {
			// 提交多个线程任务，并执行
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + " is running ..");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
