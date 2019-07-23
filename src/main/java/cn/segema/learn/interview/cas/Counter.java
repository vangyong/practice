package cn.segema.learn.interview.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

	private AtomicInteger count = new AtomicInteger();

	public Counter() {
	}

	public int getCount() {
		return count.get();
	}

	public void increase() {
		count.getAndIncrement();
	}

}
