package cn.segema.learn.interview.design.create.simplefactory;

public class ConcreteProductA implements Product {

	@Override
	public void use() {
		System.out.println("this is productA!");
	}
}