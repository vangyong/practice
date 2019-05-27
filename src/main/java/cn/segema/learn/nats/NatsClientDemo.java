package cn.segema.learn.nats;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import io.nats.client.Connection;
import io.nats.client.Message;
import io.nats.client.Nats;
import io.nats.client.Subscription;

public class NatsClientDemo {
	public static void main(String[] args) {
		try {
			Connection nc = Nats.connect("nats://localhost:4222");
			
			Subscription sub = nc.subscribe("subject");
			Message msg = sub.nextMessage(Duration.ofMillis(500));
			String response = new String(msg.getData(), StandardCharsets.UTF_8);
			System.out.println("response:"+response);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
