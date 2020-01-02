package cn.segema.learn.interview.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorDemo {
	public static void main(String[] args) {

		ExecutorService fixedExecutorService = Executors.newFixedThreadPool(1);
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) fixedExecutorService;
		System.out.println(threadPoolExecutor.getMaximumPoolSize());
		threadPoolExecutor.setCorePoolSize(8);

		ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
		// 运行时异常 java.lang.ClassCastException
		// ThreadPoolExecutor threadPoolExecutor2 = (ThreadPoolExecutor)
		// singleExecutorService;
	}
}
