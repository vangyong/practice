package cn.segema.learn.interview.design.create.abstractfactory;

public class AbstractFactoryDemo {
	public static void main(String[] args) {

		AbstractFactory abstractFactory = new ConcreteFactory1();
		AbstractProductA productA =  abstractFactory.createProductA();
		
		
		
	}

}
