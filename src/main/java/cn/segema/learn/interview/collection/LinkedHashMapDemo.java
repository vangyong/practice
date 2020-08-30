package cn.segema.learn.interview.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @description 有序,非线程安全,多态的思想
 * accessOrder true表示最近最少使用次序，false表示插入顺序，默认都采用插入顺序来维持
 * @author wangyong
 * @createDate 2020/08/30
 */
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
