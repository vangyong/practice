package cn.segema.learn.interview.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferTest {

	public static void main(String[] args) {
		try {
			RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
			FileChannel inChannel = aFile.getChannel();
			// create buffer with capacity of 48 bytes
			ByteBuffer buf = ByteBuffer.allocate(48);
			// read into buffer.
			int bytesRead = inChannel.read(buf);
			while (bytesRead != -1) {
				buf.flip(); // make buffer ready for read
				while (buf.hasRemaining()) {
					System.out.print((char) buf.get()); // read 1 byte at a time
				}
				buf.clear(); // make buffer ready for writing
				bytesRead = inChannel.read(buf);
			}
			aFile.close();

			// Gathering
			ByteBuffer header = ByteBuffer.allocate(128);
			ByteBuffer body = ByteBuffer.allocate(1024);
			// write data into buffers
			ByteBuffer[] bufferArray = { header, body };
			inChannel.write(bufferArray);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
