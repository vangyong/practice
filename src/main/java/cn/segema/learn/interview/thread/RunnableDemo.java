package cn.segema.learn.interview.thread;

public class RunnableDemo {
	public static void main(String[] args) {
		// 将Runnable实现类作为Thread的构造参数传递到Thread类中，然后启动Thread类
		MyRunnable runnable = new MyRunnable();
		new Thread(runnable).start();
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("MyRunnable："+Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());
	}
}