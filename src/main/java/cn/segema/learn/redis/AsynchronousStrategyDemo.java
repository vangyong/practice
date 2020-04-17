package cn.segema.learn.redis;

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

		String v = jedis.get(key);
		String value = v.getValue();
		long timeout = v.getTimeout();
		if (v.timeout <= System.currentTimeMillis()) {
			// 异步更新后台异常执行
			threadPool.execute(new Runnable() {
				public void run() {
					String keyMutex = "mutex:" + key;
					if (jedis.setnx(keyMutex, "1") != null) {
						// 3 min timeout to avoid mutex holder crash
						jedis.expire(keyMutex, 3 * 60);
						String dbValue = getFromDB(key);
						jedis.set(key, dbValue);
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
