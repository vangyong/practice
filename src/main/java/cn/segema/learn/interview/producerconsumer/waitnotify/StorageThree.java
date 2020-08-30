package cn.segema.learn.interview.producerconsumer.waitnotify;

import java.util.LinkedList;

import cn.segema.learn.interview.producerconsumer.Storage;

public class StorageThree implements Storage {
	//仓库最大存储量
	private final int MAX_SIZE = 100;

	//仓库存储的载体
	private LinkedList<Object> list = new LinkedList<>();

	/**
	 * @description 生产num个产品
	 * @param num
	 */
	@Override
	public void produce(int num) {
		synchronized (list) {
			// 如果仓库剩余容量不足
			while (list.size() + num > MAX_SIZE) {
				System.out.println("【要生产的产品数量】:" + num + "/t【库存量】:" + list.size() + "/t暂时不能执行生产任务!");
				try {
					// 由于条件不满足，生产阻塞
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// 生产条件满足情况下，生产num个产品
			for (int i = 1; i <= num; ++i) {
				list.add(new Object());
			}
			System.out.println("【已经生产产品数】:" + num + "/t【现仓储量为】:" + list.size());
			list.notifyAll();
		}
	}

	/**
	 * @description 消费num个产品
	 * @param num
	 */
	@Override
	public void consume(int num) {
		synchronized (list) {
			while (list.size() < num) {
				System.out.println("【要消费的产品数量】:" + num + "/t【库存量】:" + list.size() + "/t暂时不能执行生产任务!");
				try {
					// 由于条件不满足，消费阻塞
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// 消费条件满足情况下，消费num个产品
			for (int i = 1; i <= num; ++i) {
				list.remove();
			}
			System.out.println("【已经消费产品数】:" + num + "/t【现仓储量为】:" + list.size());
			list.notifyAll();
		}
	}

	public LinkedList<Object> getList() {
		return list;
	}

	public void setList(LinkedList<Object> list) {
		this.list = list;
	}

}
