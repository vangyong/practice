package cn.segema.learn.interview.io.bio.clients;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class ThreadPoolClientDemo {
	public static void main(String[] args) {
		new Thread(() -> {
			try {
				Socket socket = new Socket("127.0.0.1", 9999);
				while (true) {
					try {
						socket.getOutputStream().write((new Date() + ": hello world").getBytes());
						socket.getOutputStream().flush();
						Thread.sleep(2000);
					} catch (Exception e) {
					}
				}
			} catch (IOException e) {
			}
		}).start();
	}
}
