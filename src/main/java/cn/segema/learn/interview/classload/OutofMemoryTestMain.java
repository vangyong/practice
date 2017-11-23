package cn.segema.learn.interview.classload;

import java.util.ArrayList;
import java.util.List;

public class OutofMemoryTestMain {

	public static void main(String[] args) {
		//堆溢出
		List<byte[]> list = new ArrayList<byte[]>();
		for(int i=0;i<1024;i++) {
			list.add(new byte[1024*1024]);
		}
		
		//永久区溢出
		for(int i=0;i<1000000;i++) {
		
		}
		
		//栈溢出
		
		//直接内存溢出
		
		
	}

}
