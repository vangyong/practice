package cn.segema.learn.interview.concurrent.producterconsumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @description 测试主程序
 * @author wangyong
 * @createDate 2020/08/29
 */
public class ProducterConsumerDemo {
	public static void main(String[] args) {
		 Queue<String> queue = new ConcurrentLinkedQueue<String>();
	     Thread t1 = new Thread(new Producter(queue));
	     Thread t2 = new Thread(new Consumer(queue));
	     
	     t1.start();
	     t2.start();
	}
}
