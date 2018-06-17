package cn.segema.learn.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

	public static void main(String[] args) {
		// LinkedList;
		 //HashMap;
		// Hashtable;
		// TreeMap;
		// AbstractMap;
		// SortedMap;
		// NavigableMap;
		//

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 100);
		map.put(2, 200);
		map.put(3, 300);

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}

		Collections.synchronizedMap(map);
		
		
		
		
	}

}
