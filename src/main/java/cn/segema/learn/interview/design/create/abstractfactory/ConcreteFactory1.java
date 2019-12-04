package cn.segema.learn.interview.design.create.abstractfactory;

public class ConcreteFactory1 extends AbstractFactory {

	@Override
	public void createProductA() {
		new ProductA1().use();
	}

	@Override
	public void createProductB() {
		new ProductB1().eat();
	}
	
	
}
