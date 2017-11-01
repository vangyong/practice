package cn.segema.learn.interview.threadlocal;

import java.lang.ref.WeakReference;
import java.util.HashMap;

public class Test {

	/**
	 * @author liukunyang
	 * @date 2013-3-5	
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap map = new HashMap();
		map.put(null, "12312312");
		System.out.println(map.get(null));
		WeakReference<Test> weak = new WeakReference<Test>(null); 
	}

}
