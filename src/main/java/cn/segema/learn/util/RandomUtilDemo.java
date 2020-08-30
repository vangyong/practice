package cn.segema.learn.util;

import java.util.Random;

public class RandomUtilDemo {

	public static void main(String[] args) {

		Random r = new Random(1);
		for (int i = 0; i < 5; i++) {
			int ran1 = r.nextInt(100);
			System.out.println(ran1);
		}

		int max = 100, min = 1;

		int ran2 = (int) (Math.random() * (max - min) + min);
		System.out.println(ran2);

		long randomNum = System.currentTimeMillis();
		int ran3 = (int) (randomNum % (max - min) + min);
		System.out.println(ran3);
	}

}
