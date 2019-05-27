package cn.segema.learn.interview.design.factory;

public class FactoryDemo {
	public static void main(String[] args) {
		/*Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.Send();*/
		
		Provider provider = new SendSmsFactory();
		Sender sender = provider.produce();
		sender.Send();
	}
	
}
