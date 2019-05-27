package cn.segema.learn.interview.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import cn.segema.learn.interview.concurrent.lock.ReadWriteLockDemo;
import cn.segema.learn.interview.concurrent.lock.ReadWriteLockDemo.Queue3;
import cn.segema.learn.interview.concurrent.mythreadpool.ThreadPool;
import cn.segema.learn.interview.design.singleton.SingletonDemo;
import cn.segema.learn.interview.design.singleton.SingletonFactoryDemo;
import cn.segema.learn.interview.design.singleton.SingletonSynchronizedDemo;

public class TestMain {

	static SingletonFactoryDemo singletonFactoryDemo = null;

	static SingletonDemo SingletonDemo = null;

	public static void main(String[] args) {
		
//	Object object = new Object();
//	ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	
//	List<Integer> nums = new ArrayList<Integer>();  
//    nums.add(3);  
//    nums.add(5);  
//    nums.add(1);  
//    nums.add(0);  
//    System.out.println(nums);  
//    Collections.sort(nums);  
//    System.out.println(nums); 
    
//    HashMap;
//    
//    ConcurrentHashMap
		
		

	}

	public static void test1() {
		SingletonDemo = SingletonDemo.getInstance();
		SingletonDemo.sayHello("0000");
		singletonFactoryDemo = SingletonFactoryDemo.getInstance();
		singletonFactoryDemo.sayHello("11111");
	}

	
	
}
