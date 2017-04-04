package com.segema.java8;

public class TestMain {
	public static void main(String[] args) {
		
		/*Formula formula = new Formula() {
		    @Override
		    public double calculate(int a) {
		        return sqrt(a * 100);
		    }
		};
		double d_cal = formula.calculate(100);     // 100.0
		double d_sqrt = formula.sqrt(16);           // 4.0
		System.out.println("d_cal:"+d_cal+" d_sqrt:"+d_sqrt);*/
		
		
		/*Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);    // 123*/
		
		//方法与构造函数引用
		Converter<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("123");
		System.out.println(converted);   // 123
		
		
	}
}
