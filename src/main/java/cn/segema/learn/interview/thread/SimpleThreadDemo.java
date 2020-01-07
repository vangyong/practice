package cn.segema.learn.interview.thread;

public class SimpleThreadDemo {
	public static void main(String[] args) {
		// 匿名内部类
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("匿名内部类:"+Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());
			}
		}).start();

		// 使用Lamda表达式形式
		new Thread(() -> System.out.println("Lamda表达式:"+Thread.currentThread().getName() + "\t" + Thread.currentThread().getId()))
				.start();

		// 尾部代码块, 是对匿名内部类形式的语法糖
		new Thread() {
			@Override
			public void run() {
				System.out.println("匿名内部类语法糖"+Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());
			}
		}.start();

		// Runnable是函数式接口，所以可以使用Lamda表达式形式
		Runnable runnable = () -> {
			System.out.println("函数式接口Lamda表达式:"+Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());
		};
		new Thread(runnable).start();
	}
}
