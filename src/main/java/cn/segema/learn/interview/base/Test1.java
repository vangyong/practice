package cn.segema.learn.interview.base;

public class Test1 {
	
	public int test() {
		int s1 = 2;
		try {
			throw  new Exception();
		} catch (Exception e) {
			return s1;
		}finally {
			s1 = s1-1;
			System.out.println("finally");
		}
	}

}
