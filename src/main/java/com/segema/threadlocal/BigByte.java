package com.segema.threadlocal;

public class BigByte {
	
	private byte[] bigByte ;
	
	public BigByte(){
		this.bigByte = new  byte[1024*1024*10];//1M
	}
}
