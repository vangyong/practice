package cn.segema.learn.interview.design.creational.abstractfactory;

public class ConcreteFactory1 extends AbstractFactory {

	@Override
	public AbstractProductA createProductA() {
		return new ProductA1();
	}

	@Override
	public AbstractProductB createProductB() {
		return new ProductB1();
	}
	
	
}
