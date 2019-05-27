package cn.segema.learn.interview.concurrent.tool;

import java.util.concurrent.CyclicBarrier;

//可循环使用（Cyclic）的屏障（Barrier）,让一组线程到达一个屏障（也可以叫同步点）时被阻塞
//直到最后一个线程到达屏障时，屏障才会开门
public class CyclicBarrierDemo {

	static CyclicBarrier c = new CyclicBarrier(2);

	public static void main(String[] args) {
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					c.await();
				} catch (Exception e) {

				}
				System.out.println(1);
			}
		}).start();

		try {
			c.await();
		} catch (Exception e) {

		}
		System.out.println(2);
	}

}
