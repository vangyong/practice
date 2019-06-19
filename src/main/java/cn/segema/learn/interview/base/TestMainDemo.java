package cn.segema.learn.interview.base;

import java.time.Duration;

public class TestMainDemo {
	public static void main(String[] args) {
//		String s = "1111";
//		StringBuffer sb = new StringBuffer("");
//		StringBuilder sbuilder = new StringBuilder("");
		
		ParentDomain p = new ChildrenDomain();
		String say = p.sayHello();
		System.out.println(say);
	}
}
