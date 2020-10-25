package cn.segema.learn.interview.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 值传递和引用传递(java中都是值传递)
 * @author wangyong
 * @createDate 2020/10/18 0,1,2,3,4,5,6,7,8,9,100, //引用传递（引用一个副本值）
 *             ******************** A //由于String无法改变的原因 5 //基本类型值传递
 * 
 */
public class ParameterDemo {

	static void add(List<Integer> list) {
		list.add(100);
	}

	static void append(String str) {
		str += "is a";
	}

	static void addNum(int a) {
		a = a + 10;
	}

	// 方法重载
	static int addMoreNum(int a, String b) {
		a = a + 10;
		return a;
	}

	static int addMoreNum(String a, int b) {
		b = Integer.valueOf(a) + 10;
		return b;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		List<Integer> beforeAddlist = list;
		add(list);
		System.err.println("afterAddlist:");
		for (Integer j : list) {
			System.err.print(j + ",");
		}
		System.err.println("");
		System.err.println("beforeAddlist:");
		for (Integer k : beforeAddlist) {
			System.err.print(k + ",");
		}

		System.err.println("");
		System.err.println("*********************");
		String a = "A";
		append(a);
		System.err.println(a);
		int num = 5;
		addNum(num);
		System.err.println(num);

		String caseString = "t1";
		switch (caseString) {
		case "t1":
			System.out.println("t1");
			break; // 可选
		case "t2":
			System.out.println("t2");
			break; // 可选
		default: // 可选
			System.out.println("deault");
		}

	}

}
