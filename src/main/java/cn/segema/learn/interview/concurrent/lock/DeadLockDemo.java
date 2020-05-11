package cn.segema.learn.interview.concurrent.lock;

import java.util.stream.IntStream;

public class DeadLockDemo {
	private Object READ = new Object();
	private Object WRITE = new Object();

	public void read() {
		synchronized (READ) {
			System.out.println(Thread.currentThread().getName() + "  read");
			synchronized (WRITE) {
				System.out.println(Thread.currentThread().getName() + " write in read");
			}
		}
	}

	public void write() {
		synchronized (WRITE) {
			System.out.println(Thread.currentThread().getName() + "  write");
			synchronized (READ) {
				System.out.println(Thread.currentThread().getName() + " read in write");
			}
		}
	}

	public static void main(String[] args) {
		DeadLockDemo deadLock = new DeadLockDemo();
		IntStream.range(0, 10).forEach(i -> {
			new Thread(() -> {
				deadLock.write();
			}).start();
			new Thread(() -> {
				deadLock.read();
			}).start();
		});
	}
}
