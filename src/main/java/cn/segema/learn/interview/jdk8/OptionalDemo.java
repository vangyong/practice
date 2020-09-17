package cn.segema.learn.interview.jdk8;

import java.util.Optional;

/**
 * @description Optional判断空
 * @author wangyong
 * @createDate 2020/09/17
 */
public class OptionalDemo {

    public static String test() {
		return "a";
	}

	public static void main(String[] args) throws Exception {

		// 传统方式
		String s = test();
		if (null != s) {
			System.out.println(s);
		} else {
			throw new Exception("test is null");
		}

		// optional方式
		Optional<String> s2 = Optional.ofNullable(test());
		s2.ifPresent(System.out::println);

		String s3 = null;
		Optional<String> o = Optional.ofNullable(s3);
		System.out.println(o.orElseThrow(() -> new Exception("s3 is null")));

	}

}
