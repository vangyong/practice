package cn.segema.learn.nats;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.client.Options;

public class NatsServerDemo {
	public static void main(String[] args) {
		try {
			Connection nc = Nats.connect();
			nc.publish("subject", "hello world".getBytes(StandardCharsets.UTF_8));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
