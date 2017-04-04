package com.segema.exception;

public class ExceptionMainTest {
	public static void main(String[] args) {
		try {
			throw new ExampleB("b");
		} catch (ExampleA e) {
			System.out.println("ExampleA");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

}
