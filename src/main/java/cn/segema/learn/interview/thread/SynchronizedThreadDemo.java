package cn.segema.learn.interview.thread;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SynchronizedThreadDemo extends Thread {
	static final ConcurrentLinkedDeque<Integer> queue = new ConcurrentLinkedDeque<>();
	private static final int MAX = 500;
	private static int init = 0;

	@Override
	public void  run() {
		while(init<MAX) {
			int i = init++;
			System.out.println(Thread.currentThread().getName() + " add--> " + i);
			queue.add(i);
		}
	}

	public static void main(String[] args) {
		IntStream.range(0, 100).forEach(i -> {
			SynchronizedThreadDemo threadExample = new SynchronizedThreadDemo();
			threadExample.start();
		});
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//我们期望他的大小为500
		System.out.println(queue.size());
	}
}
