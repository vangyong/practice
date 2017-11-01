package cn.segema.learn.interview.threadlocal;

import java.util.HashMap;

public class Main {

	/**
	 * @author liukunyang
	 * @date 2013-3-1	
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadLocal th = new ThreadLocal();//自己模拟的ThreadLocal 里面持有一个ThreadLocalMap对象
		//唯一不同的是set方法内部是put进新的值，而Java的ThreadLocal是"set" 老值会被新值替换。
		BigByte k1= new BigByte(); //外部强引用
		th.set(k1  , new  byte[1024*1024*50] );//50M put 进50M
		th.set( new BigByte() , new  byte[1024*1024*50] );//50M put 进50M
		th.set( new BigByte() , new  byte[1024*1024*50] );//50M put 进50M
		
		ThreanLocalMap tm = th.getTm();
		tm.printAll();//打印entry和key，value 方便观察
		k1=null;
		th = null;//将ThreadLocal置为null还是会有内存泄露,并且FULL GC 不会回收
		System.gc();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tm.printAll();//打印entry和key，value 方便观察
		
		
		System.gc();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tm.printAll();//打印entry和key，value 方便观察
		
		
		
		
		System.gc();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tm.printAll();//打印entry和key，value 方便观察
		
		
		
		System.gc();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tm.printAll();//打印entry和key，value 方便观察
	}

}

