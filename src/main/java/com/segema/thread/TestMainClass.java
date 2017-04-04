package com.segema.thread;

public class TestMainClass {

	public static void main(String[] args) {
		/*MyThread1 myThread1 = new MyThread1();
		MyThread1 myThread2 = new MyThread1();
		myThread1.start();
		myThread2.start();*/
		
		MyThread2 myThread2 = new MyThread2();
		Thread thread = new Thread(myThread2); 
		thread.start();
	}

}
