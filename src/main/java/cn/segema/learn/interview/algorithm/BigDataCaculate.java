package cn.segema.learn.interview.algorithm;

public class BigDataCaculate {

	public static void main(String[] args) {
		

	}

	
	static int[] demo(int[] ints,int num) {
		for(int i=0;i<ints.length;i++) {
			ints[i]*=num;
		}
		
		for(int i=ints.length-1;i>0;i--) {
			ints[i-1]+=ints[i]/10;
			ints[i]=ints[i]%10;
		}
		return ints;
	}
}
