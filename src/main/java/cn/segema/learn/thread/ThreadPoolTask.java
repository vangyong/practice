package cn.segema.learn.thread;

public class ThreadPoolTask implements Runnable {

	@Override
	public void run() {
		System.out.println("ThreadPoolTask 执行");
	}

}
