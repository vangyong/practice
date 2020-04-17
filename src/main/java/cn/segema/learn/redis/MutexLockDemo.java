package cn.segema.learn.redis;

import redis.clients.jedis.Jedis;

/**
 * 互斥锁解决缓存击穿
 * 
 * @author wangyong
 *
 */
public class MutexLockDemo {
	static String key = "mutexLock_key";
	static String mutex_key = "mutex_key";

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1");
		jedis.auth("123456");
		
		String value = jedis.get(key);  
		if (value  == null) {  
			if (jedis.setnx(mutex_key, "1") != null) {  
				// 3 min timeout to avoid mutex holder crash  
				jedis.expire(mutex_key, 3 * 60);
				value = getFromDB(key);  
				jedis.set(key, value);  
				jedis.del(mutex_key);  
			} else {  
				//其他线程休息50毫秒后重试  
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}  
				jedis.get(key);    
			}  
		}  
		
	}

	public static void saveToDB(String key,String value) {
		
	}

	public static String getFromDB(String key) {
		return "db_key_value";
	}

}
