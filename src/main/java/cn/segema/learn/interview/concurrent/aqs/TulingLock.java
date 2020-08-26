package cn.segema.learn.interview.concurrent.aqs;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

import sun.misc.Unsafe;

/**
 * @description aqs实现锁，自旋 LockSupport CAS 阻塞等待队列 共享/独占 公平/非公平 可重入 允许中断
 * @author wangyong
 * @createDate 2020/08/26
 */
public class TulingLock {

	private static Unsafe unsafe = UnsafeInstance.reflectGetUnsafe();

	private static final long stateoffset;

	static {
		try {
			stateoffset = unsafe.objectFieldOffset(TulingLock.class.getField("state"));
		} catch (Exception e) {
			throw new Error();
		}
	}

	// 当前锁状态，记录加锁的次数
	private volatile int state = 0;

	// 当前持有锁的线程
	private Thread lockHolder;

	private ConcurrentLinkedQueue<Thread> waiters = new ConcurrentLinkedQueue<Thread>();

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Thread getLockHolder() {
		return lockHolder;
	}

	public void setLockHolder(Thread lockHolder) {
		this.lockHolder = lockHolder;
	}

	public boolean aquire() {
		Thread current = Thread.currentThread();
		int c = getState();
		if (c == 0) { // 同步器还没有被锁
			if ((waiters.size() == 0 || current == waiters.peek()) && compareAndSwapState(0, 1)) {
				setLockHolder(current);
				return true;
			}
		}
		return false;
	}

	public void lock() {
		// cas比较交换,Unsafe魔法类
		if (aquire()) {
			return;
		}
		Thread current = Thread.currentThread();
		waiters.add(current);
		for (;;) {
			// Thread.yield();//尽量让出，不保证
			// Thread.sleep(1000);
			if (current == waiters.peek() && aquire()) {
				waiters.poll(); // T2从队列中移除
				break;
			}
			// 阻塞当前线程
			LockSupport.park(current); // 保存对线程的引用
		}
	}

	public void unlock() {
		if (Thread.currentThread() != lockHolder) {
			throw new RuntimeException("lockHolder is not current");
		}

		int state = getState();
		if (compareAndSwapState(state, 0)) {
			setLockHolder(null);
			Thread first = waiters.peek();
			if (first != null) {
				LockSupport.unpark(first);
			}
		}
	}

	private final boolean compareAndSwapState(int expect, int update) {
		return unsafe.compareAndSwapInt(this, stateoffset, expect, update);
	}
}
