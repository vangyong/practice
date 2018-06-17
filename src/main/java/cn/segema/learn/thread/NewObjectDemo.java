package cn.segema.learn.thread;

import java.lang.reflect.Constructor;

public class NewObjectDemo {
	
	public NewObjectDemo() {
		System.out.println("newObjectDemoConstructor");
	}
	
	public static void main(String[] args) throws Exception {
		//1 new 语句创建
		Object obj1 = new Object();
		//2 工厂方法返回对象
		String obj2 = String.valueOf(123);
		//3 利用反射手段，调用java.lang.Class 或者java.lang.reflect.Constructor的newInstance()
		Object obj3 = Class.forName("java.lang.Object").newInstance();
		
		Constructor<?> cs = Object.class.getDeclaredConstructor();
		cs.setAccessible(true);
		Object obj32 = cs.newInstance();
		
		Constructor<NewObjectDemo> newObjectDemoConstructor = NewObjectDemo.class.getDeclaredConstructor();
		newObjectDemoConstructor.setAccessible(true);
		NewObjectDemo newObjectDemo = newObjectDemoConstructor.newInstance();
		
		
		
	}

}
