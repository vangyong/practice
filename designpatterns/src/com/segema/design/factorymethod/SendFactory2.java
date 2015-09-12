package com.segema.design.factorymethod;

public class SendFactory2 {
	
	public Sender produceMail(){
		return new MailSender();
	}
	
	public Sender produceSms(){
		return new SmsSender();
	}
}