package cn.segema.learn.interview.protect.p22;

import cn.segema.learn.interview.protect.p2.MyObject2;

public class Test2  extends MyObject2{

	public static void main(String[] args) throws CloneNotSupportedException {
		MyObject2 object2 = new MyObject2();
//		object2.clone();
		
		Test2 test2 = new Test2();
		test2.clone();
	}
}
