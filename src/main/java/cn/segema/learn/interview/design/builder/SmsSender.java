package cn.segema.learn.interview.design.builder;

public class SmsSender implements Sender {

	@Override
	public void Send() {
		System.out.println("this is sms sender!");
	}
}