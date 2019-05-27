package cn.segema.learn.interview.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

//它能对指定类的指定的volatile引用字段进行原子更新
public class AtomicReferenceFieldUpdaterDemo {
	
	public static void main(String[] args) throws Exception {
		AtomicReferenceFieldUpdater updater = AtomicReferenceFieldUpdater.newUpdater(Dog.class, String.class, "name");
		Dog dog1 = new Dog();
		updater.compareAndSet(dog1, dog1.name, "test");
		System.out.println(dog1.name);

	}

	static class Dog {
		volatile String name = "dog1";
	}
	


}
