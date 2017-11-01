package cn.segema.learn.interview.jdk7.memory;

import java.util.HashMap;
import java.util.Map;


public class TestMain {

	public static void main(String[] args) {
		
		
		TestMain TestMain = new TestMain();
		
		TestMain.testTry("111");
		
		System.out.println("MAIN");
		
		Map map = new  HashMap();
		
		
	}
	
	
	public String testTry(String s){
		try {
			System.out.println("return before!");
			return s;
		}
		catch (Exception e){
			
		}finally{
			System.out.println("finally!");
		}
		return s;
		
	}


}
