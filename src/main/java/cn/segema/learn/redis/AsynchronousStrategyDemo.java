package cn.segema.learn.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import redis.clients.jedis.Jedis;

/**
 * 异步策略解决缓存击穿
 * 
 * @author wangyong
 *
 */
public class AsynchronousStrategyDemo {
	
	static String key = "asynchronousStrategy_key";

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		
		Jedis jedis = new Jedis("127.0.0.1");
		jedis.auth("123456");
		
		String value = jedis.hget(key,"value");
		String timeoutStr = jedis.hget(key,"timeout");
		long timeout = Long.valueOf(timeoutStr==null? "0": timeoutStr);
		if (timeout <= System.currentTimeMillis()) {
			// 异步更新后台异常执行
			threadPool.execute(new Runnable() {
				public void run() {
					String keyMutex = "mutex_" + key;
					if (jedis.setnx(keyMutex, "1") != null) {
						jedis.expire(keyMutex, 3 * 60);
						String dbValue = getFromDB(key);
						jedis.hset(key, "value", dbValue);
						jedis.hset(key, "timeout",String.valueOf(60+System.currentTimeMillis()));
						jedis.del(keyMutex);
					}
				}
			});
		}
	}
	
	public static String getFromDB(String key) {
		return "db_key_value";
	}
}
