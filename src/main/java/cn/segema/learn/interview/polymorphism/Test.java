package cn.segema.learn.interview.polymorphism;

import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Test {

	public static String change(String s){
        s="zhangsan";
        return s;
    }
	
	public static  void change2(int s){
         s=10;
    }

	public static void main(String[] args) {
		/*
		 * superA a; B b = new B(); a = b; a.fun(5); System.out.println(a.i);
		 * System.out.println(a.pa);
		 */

//		String s=new String("lisi");
//        System.out.println(s);
//        String a = change(s);
//        System.out.println(s);
//        System.out.println("a:"+a);
		int a =1;
		change2(a);
		System.out.println(a);
		
		Map map = new HashMap();
		
		map.put(null, "null value");
		System.out.println(map.get(null));
		
		Hashtable table = new Hashtable();
		//table.put(null, "table null value");
		
		//System.out.println(table.get(null));
		
		List list =  new ArrayList<Integer>();
		
		System.gc();
		Runtime.getRuntime().gc();
		
		try {
			Class clazz = Class.forName("com.segema.polymorphism.Test");
			System.out.println(clazz.getDeclaredMethods());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}
}
