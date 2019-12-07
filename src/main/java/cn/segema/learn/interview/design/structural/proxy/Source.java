package cn.segema.learn.interview.design.structural.proxy;

public class Source implements Sourceable {

	@Override
	public void method() {
		System.out.println("the original method!");
	}

}
