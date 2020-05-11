package cn.segema.learn.interview.algorithm;

/**
 * @description 间接递归测试
 * @author wangyong
 * @createDate 2020/05/11
 */
public class IndirectRecursiveDemo {

	public void recursive(int i) {
		this.businessLogic(i - 1);
	}

	public synchronized void businessLogic(int j) {
		System.out.println("处理业务逻辑" + j);
		this.saveToDB();
		if (j >= 2) {
			this.recursive(j);
		}
	}

	public synchronized void saveToDB() {
		System.out.println("保存到数据库");
	}

	public static void main(String[] args) {
//		RecursiveDemo recursiveDemo = new RecursiveDemo();
//		recursiveDemo.recursive(5);

		IndirectRecursiveDemo st1 = new IndirectRecursiveDemo();
		IndirectRecursiveDemo st2 = new IndirectRecursiveDemo();
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
