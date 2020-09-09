package cn.segema.learn.interview.io.nio;

import java.io.FileInputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelTransferDemo {

	public static void main(String[] args) throws Exception {
		String files[] = new String[1];
		files[0] = "/Dow";
		catFiles(Channels.newChannel(System.out), files);
	}

	private static void catFiles(WritableByteChannel target, String[] files) throws Exception {
		for (int i = 0; i < files.length; i++) {
			FileInputStream fileInputStream = new FileInputStream(files[i]);
			FileChannel fileChannel = fileInputStream.getChannel();
			fileChannel.transferTo(0, fileChannel.size(), target);
			fileChannel.close();
			fileInputStream.close();
		}
	}
}
