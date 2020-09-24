package cn.segema.learn.interview.callback;

public class B implements MyCallInterface {

	@Override
	public void method() {
		System.out.println("谁来调用我啊。好寂寞！！");
	}

	public static void main(String args[]) {
		Caller call = new Caller();
		call.setCallfuc(new B());
		call.call();
	}
}
