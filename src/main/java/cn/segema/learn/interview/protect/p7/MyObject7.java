package cn.segema.learn.interview.protect.p7;

public class MyObject7 extends Test7 {
	public static void main(String[] args) {
		Test7 test = new Test7();
//        test.clone(); // Compile Error   ----- (1)
	}
}
