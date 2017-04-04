package com.segema.thread.synchronize;

public class MyClass {
	
	public synchronized void log1(String msg1,String msg2){
		System.out.println(msg1);
		System.out.println(msg2);
	}
	
	public void log2(String msg1,String msg2){
		
		synchronized (this) {
			System.out.println(msg1);
			System.out.println(msg2);
		}
	}
	
	public static synchronized void log3(String msg1,String msg2){
		System.out.println(msg1);
		System.out.println(msg2);
	}
	
	public static void log4(String msg1){
		synchronized (MyClass.class) {
			System.out.println(msg1);
		}
	}

}
