package cn.segema.learn.interview.proxy;

//具体类B
class ClassB implements AbstractClass {

	@Override
	public void show() {
		System.out.println("我是B类！");
	}
}