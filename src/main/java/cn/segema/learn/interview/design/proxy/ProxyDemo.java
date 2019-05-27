package cn.segema.learn.interview.design.proxy;

public class ProxyDemo {
	public static void main(String[] args) {
		Sourceable source = new Proxy();
		source.method();
	}
}
