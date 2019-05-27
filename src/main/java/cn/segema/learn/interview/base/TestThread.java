package cn.segema.learn.interview.base;

public class TestThread {

	public static void main(String[] args) {
		Buns mt = new Buns();// 馒头类!

		new Thread(new Res(mt, 1 > 2), "张三").start();
		new Thread(new Res(mt, 1 < 2), "------------------>李四").start();
	}
}

// 馒头类!
class Buns {
	private int sum, count;// 馒头数量,两个!
	private boolean flag;// 判断!
	// 空参构造!

	Buns() {
		this(1000);
	}

	// 形参构造!
	Buns(int sum) {
		this.sum = sum;
		this.count = sum;
	}

	// 进馒头!
	synchronized void out(int n) {
		while (flag)// 判断真就挂起!
			try {
				this.wait();
			} catch (Exception e) {
			}
		try {
			Thread.sleep(100);
		} catch (Exception e) {
		}
		System.out.println(Thread.currentThread().getName() + "付出馒头=" + n + "个;剩余:" + (sum -= n));
		flag = true;
		this.notify();// 唤醒对方!
	}

	// 出馒头!
	synchronized void add(int n) {
		while (!flag)// 判断,假就挂起
			try {
				this.wait();
			} catch (Exception e) {
			}
		try {
			Thread.sleep(100);
		} catch (Exception e) {
		}
		System.out.println(Thread.currentThread().getName() + "进入馒头=" + n + "个;剩余:" + (count += n));
		flag = false;
		this.notify();// 唤醒对方!
	}

	// 查馒头!
	int Sum() {
		return sum;
	}

	// 查馒头!
	int Count() {
		return count;
	}
}// 线程Runnable接口子类!

class Res implements Runnable {
	private boolean flag;// 判断!
	private Buns a;// 馒头类!

	Res(Buns a, boolean flag) {
		this.a = a;
		this.flag = flag;
	}

	public void run() {// 重写!
		if (flag)// 如果真就+馒头!
			add();
		else
			out();// 假就-馒头!
	}

	private void add() {
		while (a.Sum() > 100) // 判断不会越界!
			a.out(5);// 每次-5个!
	}

	private void out() {
		while (a.Count() < 1900)// 判断不越界!
			a.add(5);// 每次+5个
	}

}
