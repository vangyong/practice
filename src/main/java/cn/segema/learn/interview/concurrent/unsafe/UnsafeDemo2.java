package cn.segema.learn.interview.concurrent.unsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @description 魔术类，可以直接操作内存
 * @author wangyong
 * @createDate 2020/08/25
 */
public class UnsafeDemo2 {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, InstantiationException {
		// 只能通过反射得到theUnsafe对应的Field对象
		Field field = Unsafe.class.getDeclaredField("theUnsafe");
		field.setAccessible(true);
		// 通过Field得到该Field对应的具体对象，传入null是因为该Field为static
		Unsafe unsafe = (Unsafe) field.get(null);

		long oneHundred = 1;
		byte size = 1;

		// 调用allocateMemory分配内存
		long memoryAddress = unsafe.allocateMemory(size);

		// 将1写入到内存中
		unsafe.putAddress(memoryAddress, oneHundred);

		// 内存中读取数据
		long readValue = unsafe.getAddress(memoryAddress);

		System.out.println("value : " + readValue);

		// unsafe.copyMemory
		// unsafe.freeMemory

	}
}
