package com.segema.design.abstractfactory;

public class Test {

	public static void main(String[] args) {
		/*Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.Send();*/
		
		Provider provider = new SendSmsFactory();
		Sender sender = provider.produce();
		sender.Send();
	}
}