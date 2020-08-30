package cn.segema.learn.interview.concurrent.producterconsumer;

import java.util.Queue;
import java.util.UUID;
import com.alibaba.fastjson.JSONObject;

/**
 * @description 生成者
 * @author wangyong
 * @createDate 2020/08/29
 */
public class Producter implements Runnable {
	private Queue<String> queue;

	public Producter(Queue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (Integer.class) {
				if (queue.size() < 5) {
					Student student = new Student();
					student.setId(UUID.randomUUID().toString());
					student.setName("姓名"+UUID.randomUUID().toString());
					student.setChinese((int) (Math.random()*(100-1)+1));
					student.setMath((int) (Math.random()*(100-1)+1));
					student.setEnglish((int) (Math.random()*(100-1)+1));
					JSONObject studentJson=(JSONObject) JSONObject.toJSON(student);
					boolean flag = queue.offer(studentJson.toJSONString());
					System.out.println("线程" + Thread.currentThread().getName() + "生产:" + (flag == true ? studentJson.toJSONString() : ""));
				} else {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
