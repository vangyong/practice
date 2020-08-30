package cn.segema.learn.interview.collection;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/**
 * @description 基于链接点的无界线程安全队列，先进先出原则，wait-free(无等待)算法
 * @author wangyong
 * @createDate 2020/08/30
 */
public class ConcurrentLinkedQueueDemo {
	public static void main(String[] args) {
		Queue<String> queue = new ConcurrentLinkedQueue<String>();
		for (int i = 0; i < 1000000; i++) {
			queue.add(String.valueOf(i));
		}
		int num = 10;// 线程人个数
		for (int i = 0; i < num; i++) {
			new ThreadConn(queue);
		}
	}
}
