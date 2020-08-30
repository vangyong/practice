package cn.segema.learn.interview.producerconsumer.thread;

import cn.segema.learn.interview.producerconsumer.Storage;

public class Producer extends Thread {
	// 每次生产的产品数量
	private int num;

	// 所在放置的仓库
	private Storage storage;

	/**
	 * @description 构造函数，设置仓库
	 * @param storage
	 */
	public Producer(Storage storage) {
		this.storage = storage;
	}

	public Producer(int num, Storage storage) {
		this.num = num;
		this.storage = storage;
	}

	/**
	 * 线程run函数
	 */
	@Override
	public void run() {
		produce(num);
	}

	/**
	 * 调用仓库Storage的生产函数
	 * 
	 * @param num
	 */
	public void produce(int num) {
		storage.produce(num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}
}
