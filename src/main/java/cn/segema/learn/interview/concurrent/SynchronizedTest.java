package cn.segema.learn.interview.concurrent;

public class SynchronizedTest {

	private Object lock = new Object();

	public void synchronizedBlockOnObject(long executeTime) {
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName() + " -> start synchronizedBlockOnObject");
			doSomething(executeTime);
			System.out.println(Thread.currentThread().getName() + " -> end synchronizedBlockOnObject");
		}
	}

	public void synchronizedBlockOnThis(long executeTime) {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + " -> start synchronizedBlockOnThis");
			doSomething(executeTime);
			System.out.println(Thread.currentThread().getName() + " -> end synchronizedBlockOnThis");
		}
	}

	public void synchronizedBlockOnClass(long executeTime) {
		synchronized (SynchronizedTest.class) {
			System.out.println(Thread.currentThread().getName() + " -> start synchronizedBlockOnClass");
			doSomething(executeTime);
			System.out.println(Thread.currentThread().getName() + " -> end synchronizedBlockOnClass");
		}
	}

	public synchronized void synchronizedMethodOnThis(long executeTime) {
		System.out.println(Thread.currentThread().getName() + " -> start synchronizedMethodOnThis");
		doSomething(executeTime);
		System.out.println(Thread.currentThread().getName() + " -> end synchronizedMethodOnThis");
	}

	public static synchronized void synchronizedMethodOnClass(long executeTime) {
		System.out.println(Thread.currentThread().getName() + " -> start synchronizedMethodOnClass");
		doSomething(executeTime);
		System.out.println(Thread.currentThread().getName() + " -> end synchronizedMethodOnClass");
	}

	private static void doSomething(long executeTime) {
		try {
			Thread.sleep(executeTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		// SynchronizedTest synchronizedTest = new SynchronizedTest();
		// new Thread(new Runnable() {
		// @Override
		// public void run() {
		// SynchronizedTest.synchronizedMethodOnClass(3000);
		// }
		// }, "Thread static synchronized method").start();
		//
		// new Thread(new Runnable() {
		// @Override
		// public void run() {
		// synchronizedTest.synchronizedBlockOnClass(2000);
		// }
		// }, "Thread synchronized block on Class").start();

		SynchronizedTest synchronizedTest = new SynchronizedTest();

		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronizedTest.synchronizedMethodOnThis(3000);
			}
		}, "Thread non-static synchronized method").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				SynchronizedTest.synchronizedMethodOnClass(2000);
			}
		}, "Thread static sybchronized method").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronizedTest.synchronizedBlockOnObject(4000);
			}
		}, "Thread sybchronized block on other Object").start();

	}
}
