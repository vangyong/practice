package cn.segema.learn.interview.io.nio;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @description 虚拟内存映射
 * @author wangyong
 * @createDate 2020/09/10
 */
public class MappedByteBufferDemo {
	private final static String CONTENT = "Zero copy implemented by MappedByteBuffer";
	private final static String FILE_NAME = "/mmap.txt";
	private final static String CHARSET = "UTF-8";

	public static void main(String[] args) throws URISyntaxException {
		MappedByteBufferDemo mappedByteBufferDemo = new MappedByteBufferDemo();
        mappedByteBufferDemo.writeToFileByMappedByteBuffer();
		mappedByteBufferDemo.readFromFileByMappedByteBuffer();
	}

	// 写文件数据
	public void writeToFileByMappedByteBuffer() throws URISyntaxException {
		Path path = Paths.get(getClass().getResource(FILE_NAME).toURI());
		byte[] bytes = CONTENT.getBytes(Charset.forName(CHARSET));
		try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE,
				StandardOpenOption.TRUNCATE_EXISTING)) {
			MappedByteBuffer mappedByteBuffer = fileChannel.map(MapMode.READ_WRITE, 0, bytes.length);
			if (mappedByteBuffer != null) {
				mappedByteBuffer.put(bytes);
				mappedByteBuffer.force();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 读文件数据
	public void readFromFileByMappedByteBuffer() throws URISyntaxException {
		Path path = Paths.get(getClass().getResource(FILE_NAME).toURI());
		int length = CONTENT.getBytes(Charset.forName(CHARSET)).length;
		try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
			MappedByteBuffer mappedByteBuffer = fileChannel.map(MapMode.READ_ONLY, 0, length);
			if (mappedByteBuffer != null) {
				byte[] bytes = new byte[length];
				mappedByteBuffer.get(bytes);
				String content = new String(bytes, StandardCharsets.UTF_8);
				System.out.println(content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
