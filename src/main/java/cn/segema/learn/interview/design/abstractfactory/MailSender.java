package cn.segema.learn.interview.design.abstractfactory;

public class MailSender implements Sender {
	@Override
	public void Send() {
		System.out.println("this is mailsender!");
	}
}