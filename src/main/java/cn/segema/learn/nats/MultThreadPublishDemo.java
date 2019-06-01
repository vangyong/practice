package cn.segema.learn.nats;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

import io.nats.client.Connection;
import io.nats.client.Nats;

public class MultThreadPublishDemo {

	public static void main(String[] args) {

		for (int i = 0; i < 300; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					Connection nc;
					try {
						nc = Nats.connect("nats://localhost:4222");
						String message = "hello world 这是我的消息" + Thread.currentThread().getName();
						nc.publish("subject", message.getBytes(StandardCharsets.UTF_8));
						nc.flush(Duration.ofSeconds(5));
						nc.close();
						System.out.println("sendsucess:" + Thread.currentThread().getName());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

	/**
	 * 发送消息的线程
	 */
//	public static class MessageSender implements Runnable {
//		@Override
//		public void run() {
//			Connection nc;
//			try {
//				nc = Nats.connect("nats://localhost:4222");
//				String message = "hello world 这是我的消息" + Thread.currentThread().getName();
//				nc.publish("subject", message.getBytes(StandardCharsets.UTF_8));
//				nc.flush(Duration.ofSeconds(5));
//				nc.close();
//				System.out.println("sendsucess:" + Thread.currentThread().getName());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}

}
