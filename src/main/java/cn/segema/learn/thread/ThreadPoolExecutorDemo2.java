package cn.segema.learn.thread;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExecutorDemo2 {

	static CircleReviewsBiz circleReviewsBiz = new CircleReviewsBiz();

	static CircleZanBiz circleZanBiz = new CircleZanBiz();

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		List<Future<ThreadPoolTask>> futureList = new CopyOnWriteArrayList<Future<ThreadPoolTask>>();
		for (int i = 0; i < 2; i++) {
			ThreadPoolTask threadPoolTask = new ThreadPoolTask();
			Future<ThreadPoolTask> future = (Future<ThreadPoolTask>) executorService.submit(threadPoolTask);
			futureList.add(future);
		}
		
		for (Future<ThreadPoolTask> future : futureList) {
			System.out.println(future);
		}
		
		executorService.shutdown();

	}

}
