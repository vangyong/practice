package cn.segema.learn.interview.jvm;

public class Test1 {

	public static void main(String[] args) {

		String s1 = new String("AB");
		
		System.out.println(s1);
		System.out.println(System.identityHashCode(s1));
		
//		s1 = s1+"B";
//		System.out.println(System.identityHashCode(s1));
		
		String  s2 = new String("AB");
		
		System.out.println(System.identityHashCode(s2));

	}

}
