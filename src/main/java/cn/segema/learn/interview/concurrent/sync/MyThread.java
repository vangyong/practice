package cn.segema.learn.interview.concurrent.sync;

public class MyThread extends Thread {
	// Sync sync = new Sync();
	//
	// public MyThread(Sync sync) {
	// this.sync = sync;
	// }

	public void run() {
		Sync sync = new Sync();
		sync.test();
	}
}
