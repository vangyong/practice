package cn.segema.learn.interview.design.factorymethod;

public class FactoryTest2 {

	public static void main(String[] args) {
		SendFactory2 factory = new SendFactory2();
		Sender sender = factory.produceMail();
		sender.Send();
	}
}