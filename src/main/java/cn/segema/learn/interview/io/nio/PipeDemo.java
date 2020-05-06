package cn.segema.learn.interview.io.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @description 管道pipe实例
 * @author wangyong
 * @createDate 2020/05/06
 */
public class PipeDemo {

	public static void main(String[] args) throws IOException {

		Pipe pipe = Pipe.open();
		Pipe.SinkChannel sinkChannel = pipe.sink();
		String newData = "New String to write to file..." + System.currentTimeMillis();
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.clear();
		buf.put(newData.getBytes());

		buf.flip();

		while (buf.hasRemaining()) {
			sinkChannel.write(buf);
		}
		buf.flip();
		int len = buf.limit() - buf.position();
	    byte[] bytes = new byte[len];
	    buf.get(bytes);
		System.out.println(new String(bytes,"UTF-8"));
	}

}
