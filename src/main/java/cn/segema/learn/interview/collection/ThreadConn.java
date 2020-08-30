package cn.segema.learn.interview.collection;

import java.util.Date;
import java.util.Queue;

public class ThreadConn implements Runnable {
	Queue<String> queue;

	public ThreadConn(Queue<String> queue) {
		this.queue = queue;
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run() {
		try {
			long sd = new Date().getTime();
			while (queue.poll() != null) {
				// 这里是业务逻辑
			}
			System.out.println(12 - sd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
