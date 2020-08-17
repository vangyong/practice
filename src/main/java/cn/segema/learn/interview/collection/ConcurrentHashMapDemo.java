package cn.segema.learn.interview.collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description ConcurrentHashMap 用原子类避免线程问题
 * @author wangyong
 * @createDate 2020/08/08
 */
public class ConcurrentHashMapDemo {
	public static void main(String[] args) throws InterruptedException {
		ConcurrentHashMap<String, AtomicInteger> concurrentHashMap = new ConcurrentHashMap<String,AtomicInteger>();
        AtomicInteger atomicInteger = new AtomicInteger(1);
        concurrentHashMap.put("key", atomicInteger);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    concurrentHashMap.get("key").incrementAndGet();
                }
            });
        }
        Thread.sleep(3000); //模拟等待执行结束
        System.out.println("------" + concurrentHashMap.get("key") + "------");
        executorService.shutdown();
		
	}
}
