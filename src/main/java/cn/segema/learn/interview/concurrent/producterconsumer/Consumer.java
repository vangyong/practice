package cn.segema.learn.interview.concurrent.producterconsumer;

import java.util.Queue;

import com.alibaba.fastjson.JSON;

/**
 * @description 消费者
 * @author wangyong
 * @createDate 2020/08/29
 */
public class Consumer implements Runnable {
	private Queue<String> queue;

	public Consumer(Queue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (String.class) {
				if (!queue.isEmpty()) {
					String studentJsonStr = queue.poll();
					Student student = JSON.parseObject(studentJsonStr, Student.class);
					int chinese = student.getChinese();
					int math = student.getMath();
					int english = student.getEnglish();
					int total = chinese + math + english;
					System.out.println("学生姓名：" + student.getName());
					System.out.println("总成绩：" + total);
					//System.out.println("线程" + Thread.currentThread().getName() + "消费:" + studentJsonStr);
				} else {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
