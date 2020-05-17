package cn.segema.learn.interview.basic;

public abstract class AbstractDemo {

	protected AbstractDemo() {
	}

	static String test1(String param) {
		return "new String";
	}

	public static void main(String[] args) {
		System.out.println(AbstractDemo.test1("abc"));
	}
}
