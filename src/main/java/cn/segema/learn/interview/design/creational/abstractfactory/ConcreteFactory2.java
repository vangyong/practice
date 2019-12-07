package cn.segema.learn.interview.design.creational.abstractfactory;

public class ConcreteFactory2 extends AbstractFactory {

	@Override
	public AbstractProductA createProductA() {
		return new ProductA2();
	}

	@Override
	public AbstractProductB createProductB() {
		return new ProductB2();
	}
	
}
