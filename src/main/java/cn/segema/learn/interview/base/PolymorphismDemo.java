package cn.segema.learn.interview.base;

/**
 * 多态
 * 
 * @author wangyong
 */
public class PolymorphismDemo {
	public static void main(String[] args) {
		show(new CatDomain()); // 以 Cat 对象调用 show 方法
		show(new DogDomain()); // 以 Dog 对象调用 show 方法

		AnimalDomain a = new CatDomain(); // 向上转型
		a.eat(); // 调用的是 Cat 的 eat
		CatDomain c = (CatDomain) a; // 向下转型
		c.work(); // 调用的是 Cat 的 work
	}

	public static void show(AnimalDomain a) {
		a.eat();
		if (a instanceof CatDomain) { // 猫做的事情
			CatDomain c = (CatDomain) a;
			c.work();
		} else if (a instanceof DogDomain) { // 狗做的事情
			DogDomain c = (DogDomain) a;
			c.work();
		}
	}
}
