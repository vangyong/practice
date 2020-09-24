package cn.segema.learn.interview.callback;

public class FooBar {
	private ICallBack callBack;

	public void setCallBack(ICallBack callBack) {
		this.callBack = callBack;
	}

	public void doSth() {
		callBack.postExec();
	}
}
