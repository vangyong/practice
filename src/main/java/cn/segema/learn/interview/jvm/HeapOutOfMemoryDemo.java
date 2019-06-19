package cn.segema.learn.interview.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOutOfMemoryDemo {

	public static void main(String[] args) {
		List<TestCaseDomain> cases = new ArrayList<TestCaseDomain>();
		while (true) {
			cases.add(new TestCaseDomain());
		}
	}

}
