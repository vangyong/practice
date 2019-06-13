package cn.segema.learn.nats;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

import io.nats.client.Connection;
import io.nats.client.Nats;

/**
 * @category Nats发送消息
 * @author wangyong
 * @date 2019/05/29
 */
public class NatsPublishDemo {
    public static void main(String[] args){
        
        Connection nc;
        try {
            nc = Nats.connect("nats://10.10.19.53:4222");
            nc.publish("subject", "hello world 这是我的消息".getBytes(StandardCharsets.UTF_8));
            nc.flush(Duration.ofSeconds(5));
            nc.close();
            System.out.println("sendsucess:");
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
}
