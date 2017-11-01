package cn.segema.learn.interview.thread;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestMainClass {

	public static void main(String[] args) {
		/*MyThread1 myThread1 = new MyThread1();
		MyThread1 myThread2 = new MyThread1();
		myThread1.start();
		myThread2.start();*/
		
		MyThread2 myThread2 = new MyThread2();
		Thread thread = new Thread(myThread2,"a"); 
		thread.start();
		
		ConcurrentHashMap  concurrentHashMap = new ConcurrentHashMap();
		
		Hashtable hashtable = new Hashtable();
		
		HashMap hashMap = new HashMap();
		
		ReentrantLock ReentrantLock = new ReentrantLock();
		
		
		ReentrantReadWriteLock ReentrantReadWriteLock = new ReentrantReadWriteLock();
		 
		
		Object object = new Object();
		
	}

}
