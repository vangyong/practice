 package cn.segema.learn.interview.io.nio;

import java.nio.ByteBuffer;

/**
 * @description 直接堆外内存
 * @author wangyong
 * @createDate 2020/08/25
 */
public class DirectByteBufferDemo {
	public static void main(String[] args) {
		ByteBuffer directByteBuffer = ByteBuffer.allocateDirect(8);
	}

}
