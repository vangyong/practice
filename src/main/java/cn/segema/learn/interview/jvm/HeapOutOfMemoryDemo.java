package cn.segema.learn.interview.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOutOfMemoryDemo {

	public static void main(String[] args) {
		List<CaseDomain> cases = new ArrayList<CaseDomain>();
		while (true) {
			cases.add(new CaseDomain());
		}
	}

}
