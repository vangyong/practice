package cn.segema.learn.interview.concurrent.aqs;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @description 信号量，用来控制同时访问特定资源的线程数量
 * @author wangyong
 * @createDate 2020/08/23
 */
public class SemaphoreDemo {

	private static final int COUNT = 40;
	private static Executor executor = Executors.newFixedThreadPool(COUNT);
	private static Semaphore semaphore = new Semaphore(10);

	public static void main(String[] args) {
		for (int i = 0; i < COUNT; i++) {
			executor.execute(new SemaphoreDemo.Task());
		}
	}

	static class Task implements Runnable {
		@Override
		public void run() {
			try {
				// 读取文件操作
				semaphore.acquire();
				// 存数据过程
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
			}
		}
	}

}
