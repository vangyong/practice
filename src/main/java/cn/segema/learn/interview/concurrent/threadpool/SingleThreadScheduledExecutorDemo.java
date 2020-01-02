package cn.segema.learn.interview.concurrent.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutorDemo {

	public static void main(String[] args) {

		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("run " + System.currentTimeMillis());
			}
		}, 0, 100, TimeUnit.MILLISECONDS);

	}

}
