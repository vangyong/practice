package cn.segema.learn.interview.design.creational.simplefactory;

public class ConcreteProductA implements Product {

	@Override
	public void use() {
		System.out.println("this is productA!");
	}
}