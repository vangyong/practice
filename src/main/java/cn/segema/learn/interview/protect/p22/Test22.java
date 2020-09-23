package cn.segema.learn.interview.protect.p22;

import cn.segema.learn.interview.protect.p2.MyObject2;

public class Test22 extends MyObject2 {

	public void testSuperClone() throws CloneNotSupportedException {
		MyObject2 father = new MyObject2();
//		father.clone();

		Test22 test22 = new Test22();
		test22.clone();
	}
}
