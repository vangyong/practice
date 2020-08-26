package cn.segema.learn.interview.concurrent.aqs;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class UnsafeInstance {

	public static Unsafe reflectGetUnsafe() {
		try {
	        Field field = Unsafe.class.getDeclaredField("theUnsafe");
	        field.setAccessible(true);
	        return (Unsafe)field.get(null);
		}catch(Exception e){
			
		}
		return null;
	}
}
