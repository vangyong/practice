package cn.segema.learn.interview.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionMainTest {

	public static void main(String[] args) {
		List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		System.out.println("Languages which starts with J :");
		
	}

	public static void filter(List<String> names, Predicate condition) {
		for (String name : names) {
			if (condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}

}
