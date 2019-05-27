package cn.segema.learn.interview.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOutOfMemoryDemo {

	public static void main(String[] args) {
		List<TestCase> cases = new ArrayList<TestCase>();
		while (true) {
			cases.add(new TestCase());
		}
	}

}
