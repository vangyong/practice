package cn.segema.learn.interview.base;

public class ParentDemo {
	public static void main(String[] args) {
		ParentDomain p = new ChildrenDomain();
		String say = p.sayHello();
		System.out.println(say);
	}
}
