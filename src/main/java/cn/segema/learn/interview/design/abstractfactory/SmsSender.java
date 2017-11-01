package cn.segema.learn.interview.design.abstractfactory;

public class SmsSender implements Sender {

	@Override
	public void Send() {
		System.out.println("this is sms sender!");
	}
}