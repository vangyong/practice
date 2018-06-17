package cn.segema.learn.interview.exception;

public class ExceptionMainTest {
	public static void main(String[] args) {
//		RuntimeException;
//		Exception;
//		Throwable;
//		NullPointerException;
//		ArrayIndexOutOfBoundException;
		
		
		try {
			throw new ExampleB("b","saa");
		} catch (ExampleA e) {
			System.out.println("ExampleA");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

}
