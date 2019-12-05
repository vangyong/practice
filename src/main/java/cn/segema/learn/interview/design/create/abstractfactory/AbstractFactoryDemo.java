package cn.segema.learn.interview.design.create.abstractfactory;

public class AbstractFactoryDemo {
	public static void main(String[] args) {

//		AbstractFactory abstractFactory1 = new ConcreteFactory1();
//		AbstractProductA productA =  abstractFactory1.createProductA();
//		AbstractProductB productB =  abstractFactory1.createProductB();
//		productA.use();
//		productB.eat();
		
		
		AbstractFactory abstractFactory2 = new ConcreteFactory2();
		AbstractProductA productA2 =  abstractFactory2.createProductA();
		AbstractProductB productB2 =  abstractFactory2.createProductB();
		productA2.use();
		productB2.eat();
		
	}

}
