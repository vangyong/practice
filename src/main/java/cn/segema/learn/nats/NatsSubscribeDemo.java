package cn.segema.learn.nats;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Nats;

/**
 * @category Nats消费消息
 * @author wangyong
 * @date 2019/05/29
 */
public class NatsSubscribeDemo {
    public static void main(String[] args) throws IOException, TimeoutException {

        Connection nc;
        try {
            nc = Nats.connect("nats://10.10.19.53:4222");
            Dispatcher d = nc.createDispatcher((msg) -> {
                String response = new String(msg.getData(), StandardCharsets.UTF_8);
                System.out.println("response:");
                System.out.println(response);
            });
            d.subscribe("subject");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
