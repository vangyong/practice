package cn.segema.learn.interview.thread;

public class ThreadDemo {
	public static void main(String[] args) {
		new MyThread().start();
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("MyThread:"+Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());
	}
}