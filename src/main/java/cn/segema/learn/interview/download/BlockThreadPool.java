package cn.segema.learn.interview.download;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description 线程池
 * @author wangyong
 * @createDate 2020/08/31
 */
public class BlockThreadPool {
    
    private ThreadPoolExecutor pool = null;

    public BlockThreadPool(int poolSize) {
        pool = new ThreadPoolExecutor(poolSize, 2, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(80),
            new CustomThreadFactory(), new CustomRejectedExecutionHandler());
    }

    public void destory() {
        if (pool != null) {
            pool.shutdownNow();
        }
    }

    private class CustomThreadFactory implements ThreadFactory {
        private AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName = BlockThreadPool.class.getSimpleName() + count.addAndGet(1);
            t.setName(threadName);
            return t;
        }
    }

    private class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                // 核心改造点，由blockingqueue的offer改成put阻塞方法
                System.out.println("r-size-befor====" + executor.getQueue().size());
                executor.getQueue().put(r);
                System.out.println("r-size-end====" + executor.getQueue().size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void execute(Runnable runnable) {
        this.pool.execute(runnable);
    }

}
