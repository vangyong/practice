package cn.segema.learn.interview.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

	private AtomicInteger count = new AtomicInteger();

	public AtomicIntegerDemo(){}

	public int getCount() {
		return count.get();
	}

	public void increase() {
		count.getAndIncrement();
	}

	public static void main(String[] args) {
		AtomicIntegerDemo atomicIntegerDemo = new AtomicIntegerDemo();
		atomicIntegerDemo.getCount();
		atomicIntegerDemo.increase();
		System.out.println(atomicIntegerDemo.getCount());
	}

}
