package cn.segema.learn.interview.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(null,"nullvalue");
		System.out.println(map.get(null));
	}
}
