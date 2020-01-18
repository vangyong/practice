package cn.segema.learn.interview.distributelock;

import java.util.UUID;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class RedisLockDemo {
	Jedis conn = new Jedis("127.0.0.1",6379);
	private final String LOCK_NAME = "redis_lock";
	
	//获得锁 重入锁和非重入锁
	public String accquireLock(int timeout) {
		String uuid = UUID.randomUUID().toString();
		long end = System.currentTimeMillis()+timeout;
		while(System.currentTimeMillis()<end) {
			if(conn.setnx(LOCK_NAME, uuid).intValue()==1) {
				return uuid;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public boolean releaseLock(String uuid) {
		while(true) {
			conn.watch(LOCK_NAME);
			if(uuid.equals(conn.get(LOCK_NAME))) {
				Transaction transaction =conn.multi();
				transaction.del(LOCK_NAME);
				if(transaction.exec()==null) {
					continue;
				}
				return true;
			}
			conn.unwatch();
			break;
		}
		return false;
	}
	
	public static void main(String[] args) {
		RedisLockDemo redisLockDemo = new RedisLockDemo();
		for(int i =0;i<10;i++) {
			String uuid = redisLockDemo.accquireLock(1000000);
			if(uuid!=null) {
				System.out.println(i+"->获得锁成功");
			}else {
				if(i==6) {
					redisLockDemo.releaseLock(uuid);
				}
				System.out.println("获得锁失败");
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
