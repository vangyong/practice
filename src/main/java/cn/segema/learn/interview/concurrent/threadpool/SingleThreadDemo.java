package cn.segema.learn.interview.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadDemo {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		for (int i = 1; i <= 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {// 向池子中扔任务，任务即一个Runnable

				@Override
				public void run() {
					for (int j = 1; j <= 5; j++) {
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " looping of " + j + " for task of " + task);
					}
				}
			});
		}
		System.out.println("all of 10 tasks have committed!");
		threadPool.shutdown(); // 执行完任务后关闭
	}
}
