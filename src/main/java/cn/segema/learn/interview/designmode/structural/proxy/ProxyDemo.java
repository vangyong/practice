package cn.segema.learn.interview.designmode.structural.proxy;

public class ProxyDemo {
	public static void main(String[] args) {
		Sourceable source = new Proxy();
		source.method();
	}
}
