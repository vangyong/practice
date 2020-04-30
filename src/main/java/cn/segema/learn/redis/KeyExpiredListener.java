package cn.segema.learn.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

/**
 * @Description [key过期监听]
 * @author wangyong
 * @CreateDate 2020/04/30
 */
public class KeyExpiredListener extends JedisPubSub {

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPSubscribe " + pattern + " " + subscribedChannels);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println("onPMessage pattern " + pattern + " " + channel + " " + message);
        JedisPool pool = new JedisPool("10.10.143.147", 6379);
        Jedis jedis = pool.getResource();
        jedis.auth("123456");
        Object value = jedis.get(message);
        System.out.println(value);
        
    }

}
