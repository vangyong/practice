package cn.segema.learn.interview.concurrent.unsafe;

import sun.misc.Unsafe;

/**
 * @description CAS操作
 * @author wangyong
 * @createDate 2020/08/27
 */
public class AtomicStudentAgeUpdateDemo {

	private String name;
	private volatile int age;

	private static final Unsafe unsafe = UnsafeInstance.reflectGetUnsafe();
	private static final long valueOffset;

	static {
		try {
			valueOffset = unsafe.objectFieldOffset(AtomicStudentAgeUpdateDemo.class.getDeclaredField("age"));
			System.out.println("valueOffset:--->" + valueOffset);
		} catch (Exception e) {
			throw new Error(e);
		}
	}

	public void compareAndSwapAge(int old, int target) {
		unsafe.compareAndSwapInt(this, valueOffset, old, target);
	}

	public AtomicStudentAgeUpdateDemo(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public static void main(String[] args) {
		AtomicStudentAgeUpdateDemo updater = new AtomicStudentAgeUpdateDemo("杨过", 18);
		updater.compareAndSwapAge(18, 56);

		System.out.println("真实的杨过年龄---" + updater.getAge());

	}
}
