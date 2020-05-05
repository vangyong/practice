package cn.segema.learn.interview.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		// 实现线程A
		final Thread threadA = new Thread(() -> {
			if (list.size() != 5) {
				LockSupport.park();
			}
			System.out.println("线程B收到通知，开始执行自己的业务...");
		});
		// 实现线程B
		Thread threadB = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				list.add("abc");
				System.out.println("线程A向list中添加一个元素，此时list中的元素个数为：" + list.size());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (list.size() == 5)
					LockSupport.unpark(threadA);
			}
		});
		threadB.start();
		threadA.start();
	}

}
