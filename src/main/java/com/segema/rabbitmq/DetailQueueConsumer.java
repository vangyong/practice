package com.segema.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class DetailQueueConsumer implements MessageListener{
	
	@Override
	public void onMessage(Message message) {
		System.out.println("recivered message: "+ new String(message.getBody()));
	}

}
