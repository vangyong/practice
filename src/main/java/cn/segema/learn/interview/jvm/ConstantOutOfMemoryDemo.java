package cn.segema.learn.interview.jvm;

import java.util.ArrayList;
import java.util.List;

public class ConstantOutOfMemoryDemo {

	public static void main(String[] args) throws Exception {
		try {
			List<String> strings = new ArrayList<String>();
			int i = 0;
			while (true) {
				strings.add(String.valueOf(i++).intern());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
}
