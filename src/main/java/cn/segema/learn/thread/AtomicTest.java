package cn.segema.learn.thread;

import java.awt.geom.CubicCurve2D;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

public class AtomicTest {

	public static void main(String[] args) {
		System.out.println("aaa");
		String a1 = "1111145566778";
		String b1 = "789987";

		char[] ac1 = a1.toCharArray();

		char[] bc1 = b1.toCharArray();

		int[] ai1 = new int[ac1.length];

		for (int i = 0; i < ac1.length; i++) {
			ai1[i] = Integer.parseInt(String.valueOf(ac1[i]));
			System.out.print(ai1[i]);
		}
		
		System.out.println("----");

		int[] bi1 = new int[bc1.length];
		
		for (int i = 0; i < bc1.length; i++) {
			bi1[i] = Integer.parseInt(String.valueOf(bc1[i]));
			System.out.print(bi1[i]);
		}
		
		int l1 = ai1.length;
		int l2 =bi1.length;
		
		if(l1-l2>0) {
			
		}
		
	}

}
