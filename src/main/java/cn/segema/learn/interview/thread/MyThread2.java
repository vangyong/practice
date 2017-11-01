package cn.segema.learn.interview.thread;

public class MyThread2 implements Runnable {

	public void run() {
			System.out.println(Thread.currentThread().getName());
			System.out.println(" this MyThread2.run()");
	}

}
