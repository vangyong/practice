package cn.segema.learn.thread;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import cn.segema.learn.interview.design.facade.User;

public class ThreadPoolExecutorDemo3 {
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		List<Future<List<User>>> futureList = new CopyOnWriteArrayList<Future<List<User>>>();
		for (int i = 0; i < 2; i++) {
			ThreadPoolTaskCallable threadPoolTaskCallable = new ThreadPoolTaskCallable();
			Future<List<User>> future = (Future<List<User>>) executorService.submit(threadPoolTaskCallable);
			futureList.add(future);
		}

		for (Future<List<User>> future : futureList) {
			List<User> list = (List<User>)future;
			for(int i=0;i<list.size();i++) {
				User user= list.get(i);
				System.out.println(user);
			}
			
			
			//System.out.println(future);
		}

		executorService.shutdown();

	}
}
