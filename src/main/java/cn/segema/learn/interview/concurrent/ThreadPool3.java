package cn.segema.learn.interview.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool3 {
	//线程池的概念与Executors类的使用
    public static void main(String[] args) {
        //缓存的线程池
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 10; i++) {//扔5个任务
            final int task = i;
            threadPool.execute(new Runnable() {//向池子中扔任务，任务即一个Runnable

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
    }
}
