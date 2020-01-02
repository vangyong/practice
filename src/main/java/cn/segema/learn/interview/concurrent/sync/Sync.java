package cn.segema.learn.interview.concurrent.sync;

public class Sync {
	public static synchronized void test() {
		System.out.println("线程："+Thread.currentThread().getName());
		System.out.println("test开始..");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("test结束..");

	}

}
