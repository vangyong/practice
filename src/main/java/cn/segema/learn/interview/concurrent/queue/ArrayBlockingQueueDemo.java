package cn.segema.learn.interview.concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description 异步队列,生产者与消费者
 * @author wangyong
 * @createDate 2020/08/30
 */
public class ArrayBlockingQueueDemo {
	// 消息队列订阅者,同时4个线程处理，任务提交者
	private static final ThreadPoolExecutor THREAD_POOL = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
	// 消息队列生产者,单一线程处理
	private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = Executors
			.newSingleThreadScheduledExecutor();

	// 用于判断是否关闭订阅
	private static volatile boolean isClose = false;
	static int taskId = 0;

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
		producer(queue);
		consumer(queue);
		exitALl();
		System.out.println("all finish!");
	}

	private static boolean exitALl() {
		if (taskId > 10) {
			THREAD_POOL.shutdown();
			SCHEDULED_EXECUTOR_SERVICE.shutdown();
			return true;
		} else {
			return false;
		}
	}

	// 模拟消息队列生产者,每200毫秒向队列中放入一个消息
	private static void producer(final BlockingQueue queue) {
		SCHEDULED_EXECUTOR_SERVICE.scheduleAtFixedRate(new Runnable() {
			public void run() {
				taskId++;
				queue.offer("taskId=" + taskId);
				// exitALl();

			}
		}, 0L, 200L, TimeUnit.MILLISECONDS);
	}

	// 消息队列消费者,生产者每秒生产5个 消费者4个线程消费1个1秒 每秒积压1个
	private static void consumer(final BlockingQueue queue) throws InterruptedException {
		// while (!isClose)
		while (true) {
			final String msg = (String) queue.take();// 从队列中拿到消息
			if (!THREAD_POOL.isShutdown()) {
				THREAD_POOL.execute(new Runnable() {
					public void run() {
						try {
							TimeUnit.MILLISECONDS.sleep(500L);
							System.out.println(msg + " 任务处理完毕！");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
			}
			getPoolBacklogSize();
			if (exitALl()) {
				break;
			}

		}
	}

	// 查看线程池堆积消息个数
	private static long getPoolBacklogSize() {
		long backlog = THREAD_POOL.getTaskCount() - THREAD_POOL.getCompletedTaskCount();
		System.out.println(String.format("[%s]THREAD_POOL 积压的任务:%s", System.currentTimeMillis(), backlog));
		return backlog;
	}
}
