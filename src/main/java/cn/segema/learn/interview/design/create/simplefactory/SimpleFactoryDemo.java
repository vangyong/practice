package cn.segema.learn.interview.design.create.simplefactory;

public class SimpleFactoryDemo {
	public static void main(String[] args) {

		Factory factory = new Factory();
		Product product = factory.createProduct("B");
		product.use();
	}

}
