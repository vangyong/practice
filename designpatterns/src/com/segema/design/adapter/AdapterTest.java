package com.segema.design.adapter;

public class AdapterTest {

	public static void main(String[] args) {
	/*	Targetable target = new Adapter();
		target.method1();
		target.method2();*/
		
		Source source = new Source();
		Targetable target = new Wrapper(source);
		target.method1();
		target.method2();
				
		
	}
}