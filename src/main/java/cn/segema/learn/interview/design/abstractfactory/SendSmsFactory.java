package cn.segema.learn.interview.design.abstractfactory;

public class SendSmsFactory implements Provider{

	@Override
	public Sender produce() {
		return new SmsSender();
	}
}