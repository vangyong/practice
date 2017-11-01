package cn.segema.learn.interview.design.bridge;

public class MyBridge extends Bridge {
	public void method(){
		getSource().method();
	}
}