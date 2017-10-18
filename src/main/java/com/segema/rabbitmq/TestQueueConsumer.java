package com.segema.rabbitmq;

public class TestQueueConsumer {
	public void onMessage(String text){
		System.out.println("recivered message: "+text);
	}
}
