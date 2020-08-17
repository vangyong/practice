package cn.segema.learn.interview.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LinkedHashMapDemo {

	public static void main(String[] args) {
		LinkedHashMap linkedHashMap = new LinkedHashMap();
		Iterator<Entry<String, Integer>> iterator = linkedHashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Integer> next = iterator.next();
			System.out.println("key:" + next.getKey() + " value:" + next.getValue());
		}
	}

}
