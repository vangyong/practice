package cn.segema.learn.interview.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool1 {
	
	public static void main(String[] args) {
		 //固定线程池：创建固定线程数去执行线程的任务，这里创建三个线程
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {//向池子里扔10个任务
            final int task = i;
            threadPool.execute(new Runnable() {//execute方法表示向池子中扔任务，任务即一个Runnable

                @Override
                public void run() {
                    for (int j = 1; j <= 5; j++) { 
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()
                                + " looping of " + j + " for task of " + task);
                    }
                }
            });
        }
        System.out.println("all of 10 tasks have committed!");
        threadPool.shutdown(); //执行完任务后关闭
//      threadPool.shutdownNow(); //立即关闭
		
	}

}
