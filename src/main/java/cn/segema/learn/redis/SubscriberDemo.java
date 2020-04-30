package cn.segema.learn.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class SubscriberDemo {
    public static void main(String[] args) {
        JedisPool pool = new JedisPool("10.10.143.147", 6379);
        Jedis jedis = pool.getResource();
        jedis.auth("123456");
//        jedis.psubscribe(new KeyExpiredListener(), "__key*__:*");
        jedis.psubscribe(new KeyExpiredListener(), "__keyevent@0__:expired");
        System.out.println(" Subscriber end ");
    }

}