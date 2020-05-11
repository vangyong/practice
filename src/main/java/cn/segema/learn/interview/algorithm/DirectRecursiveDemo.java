package cn.segema.learn.interview.algorithm;

/**
 * @description 直接递归测试
 * @author wangyong
 * @createDate 2020/05/11
 */
public class DirectRecursiveDemo {

	public void recursive(int i) {
		System.out.println("处理业务逻辑" + i);
		this.saveToDB();
		if (i - 1 >= 2) {
			this.recursive(i - 1);
		}
	}

	public synchronized void saveToDB() {
		System.out.println("保存到数据库");
	}

	public static void main(String[] args) {
//		DirectRecursiveDemo directRecursiveDemo = new DirectRecursiveDemo();
//		directRecursiveDemo.recursive(5);

		DirectRecursiveDemo st1 = new DirectRecursiveDemo();
		DirectRecursiveDemo st2 = new DirectRecursiveDemo();
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + "st1准备进入");
			st1.recursive(5);
		}).start();
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " st2 准备进入");
			st2.recursive(5);
		}).start();
	}

}
