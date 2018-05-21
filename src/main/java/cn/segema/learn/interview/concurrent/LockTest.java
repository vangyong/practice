package cn.segema.learn.interview.concurrent;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {

	public static void main(String[] args) {

		// ReentrantReadWriteLock ReentrantReadWriteLock = new ReentrantReadWriteLock();
		//
		// ThreadLocal<Integer> account = new ThreadLocal<Integer>();
		//
		// ConcurrentHashMap ConcurrentHashMap = new ConcurrentHashMap();
		//
		// HashMap HashMap = new HashMap();
		//

		// Runnable task = () -> {
		// String threadName = Thread.currentThread().getName();
		// System.out.println("Hello"+ threadName);
		// };
		// Thread thread = new Thread(task);
		// thread.start();
		//
		//
		//
		// Runnable task2 = new Runnable() {
		// @Override
		// public void run() {
		// String threadName = Thread.currentThread().getName();
		// System.out.println("Runnable:"+threadName);
		// }
		// };
		//
		// Thread thread2 = new Thread(task2);
		// thread2.start();
		//

//		ExecutorService executor = Executors.newSingleThreadExecutor();
//		executor.submit(() -> {
//			String threadName = Thread.currentThread().getName();
//			System.out.println("Hello" + threadName);
//		});

		// try {
		// System.out.println("attempt to shutdown executor");
		// executor.shutdown();
		// executor.awaitTermination(5, TimeUnit.SECONDS);
		// } catch (InterruptedException e) {
		// System.err.println("tasks interrupted");
		// } finally {
		// if (!executor.isTerminated()) {
		// System.err.println("cancel non-finished tasks");
		// }
		// executor.shutdownNow();
		// System.out.println("shutdown finished");
		// }

		Callable task = () -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				return 123;
			} catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};

		
		ExecutorService executor = Executors.newFixedThreadPool(1); 
		Future future = executor.submit(task);

		System.out.println("future done? " + future.isDone());

		Integer result;
		try {
			result = (Integer) future.get();
			System.out.println("future done?" + future.isDone()); 
			System.out.print("result:" + result); 
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		
		HashMap HashMap = new HashMap();
		
		ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
		
		
		
		
		
	}

}
