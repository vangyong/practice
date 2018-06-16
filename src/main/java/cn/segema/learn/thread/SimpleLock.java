package cn.segema.learn.thread;

import java.util.UUID;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

public class SimpleLock {

	// Redis服务器IP
	private static String ADDR = "127.0.0.1";

	// Redis的端口号
	private static int PORT = 6379;

	// 访问密码
	private static String AUTH = "123456";

	// 可用连接实例的最大数目，默认值为8；
	// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
	private static int MAX_ACTIVE = 1024;

	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private static int MAX_IDLE = 200;

	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	private static int MAX_WAIT = 10000;

	private static int TIMEOUT = 10000;

	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	private static boolean TEST_ON_BORROW = true;

	private static JedisPool jedisPool = null;

	static {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxIdle(MAX_IDLE);
			config.setTestOnBorrow(TEST_ON_BORROW);
			jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Jedis conn = jedisPool.getResource();

	private final String LOCK_NAME = "lock";

	// 获得锁 重入锁和非重入锁
	public String accquireLock(int timeout) {
		String uuid = UUID.randomUUID().toString();
		long end = System.currentTimeMillis() + timeout;
		while (System.currentTimeMillis() < end) {
			if (conn.setnx(LOCK_NAME, uuid).intValue() == 1) {
				conn.expire(LOCK_NAME, timeout);
				return uuid;
			}
			if (conn.ttl(LOCK_NAME) == 1) {
				conn.expire(LOCK_NAME, timeout);
			}
		}
		return null;
	}

	// 释放锁
	public boolean releaseLock(String uuid) {
		while (true) {
			conn.watch(LOCK_NAME);
			if (uuid.equals(conn.get(LOCK_NAME))) {
				Transaction transaction = conn.multi();
				transaction.del(LOCK_NAME);
				if (transaction.exec() == null) {
					continue;
				}
				return true;
			}
			conn.unwatch();
			break;
		}

		return false;
	}

	public static void main(String[] args) throws InterruptedException {

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				SimpleLock simpleLock = new SimpleLock();
				String uuid = simpleLock.accquireLock(1000);
				if (uuid != null) {
					System.out.println("获得锁成功:" + Thread.currentThread().getName());
				} else {
					System.out.println("获得锁失败:" + Thread.currentThread().getName());
				}

			}
		});
		thread1.start();

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				SimpleLock simpleLock = new SimpleLock();
				String uuid = simpleLock.accquireLock(1);
				if (uuid != null) {
					System.out.println("获得锁成功:" + Thread.currentThread().getName());
				} else {
					System.out.println("获得锁失败:" + Thread.currentThread().getName());
				}
			}
		});
		thread2.start();

	}
}
