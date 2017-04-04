package com.segema.design.bridge;

public class MyBridge extends Bridge {
	public void method(){
		getSource().method();
	}
}