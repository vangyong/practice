package cn.segema.learn.interview.design.builder;

public class MailSender implements Sender {
	@Override
	public void Send() {
		System.out.println("this is mailsender!");
	}
}