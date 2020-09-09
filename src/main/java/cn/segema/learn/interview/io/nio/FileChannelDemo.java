package cn.segema.learn.interview.io.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import cn.segema.learn.interview.classload.LoadResourceDemo;

/**
 * @description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/08/25
 */
public class FileChannelDemo {

    private static final String CONTENT = "Zero copy implemented by FileChannel";
    private static final String SOURCE_FILE = "/source.txt";
    private static final String TARGET_FILE = "/target.txt";
    private static final String CHARSET = "UTF-8";

    public static void main(String[] args) throws Exception {
        FileChannelDemo fileChannelDemo = new FileChannelDemo();
        // fileChannelDemo.transferTo();
        fileChannelDemo.transferTo();
    }

    public void setup() throws URISyntaxException {
        Path source = Paths.get(getClass().getResource(SOURCE_FILE).toURI());
        byte[] bytes = CONTENT.getBytes(Charset.forName(CHARSET));
        try (FileChannel fromChannel = FileChannel.open(source, StandardOpenOption.READ, StandardOpenOption.WRITE,
            StandardOpenOption.TRUNCATE_EXISTING)) {
            fromChannel.write(ByteBuffer.wrap(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void transferTo() throws Exception {
        RandomAccessFile fromFile = new RandomAccessFile(getClass().getResource(SOURCE_FILE).toURI().toString(), "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile(getClass().getResource(TARGET_FILE).toURI().toString(), "rw");
        FileChannel toChannel = toFile.getChannel();
        long position = 0L;
        long offset = fromChannel.size();
        fromChannel.transferTo(position, offset, toChannel);
        System.out.println("transferTo end!");
    }

	public void transferFrom() throws Exception {
		FileChannel fromChannel = new RandomAccessFile(
				new File(LoadResourceDemo.class.getClassLoader().getResource(SOURCE_FILE).toURI()), "rw").getChannel();
		FileChannel toChannel = new RandomAccessFile(
				new File(LoadResourceDemo.class.getClassLoader().getResource(TARGET_FILE).toURI()), "rw").getChannel();
		long position = 0L;
		long offset = fromChannel.size();
		toChannel.transferFrom(fromChannel, position, offset);
	}
}
