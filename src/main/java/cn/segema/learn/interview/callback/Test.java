package cn.segema.learn.interview.callback;

public class Test {
	public static void main(String[] args) {
		FooBar foo = new FooBar();
		foo.setCallBack(new ICallBack() {
			public void postExec() {
				System.out.println("method executed.");
			}
		});
		foo.doSth();// 调用函数
	}
}
