package cn.segema.learn.interview.designmode.creational.abstractfactory;

/**
 * @description 抽象工厂
 * @author wangyong
 * @createDate 2020/08/25
 */
public class AbstractFactoryDemo {
	public static void main(String[] args) {

		AbstractFactory abstractFactory1 = new ConcreteFactory1();
		AbstractProductA productA1 =  abstractFactory1.createProductA();
		AbstractProductB productB1 =  abstractFactory1.createProductB();
		productA1.use();
		productB1.eat();
		
		
		AbstractFactory abstractFactory2 = new ConcreteFactory2();
		AbstractProductA productA2 =  abstractFactory2.createProductA();
		AbstractProductB productB2 =  abstractFactory2.createProductB();
		productA2.use();
		productB2.eat();
		
	}

}
