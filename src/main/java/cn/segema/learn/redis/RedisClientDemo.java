package cn.segema.learn.redis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import redis.clients.jedis.Jedis;

public class RedisClientDemo {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.33.135");
		jedis.auth("123456");
		String f = "E:\\data\\redis\\e2.txt.backup";
		try {
			File file = new File(f);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String data = reader.readLine();
			reader.close();
			Date start = new Date();
			for (int i = 0; i < 10000; i++) {
				jedis.set(i + "", data);
			}
			Date end = new Date();
			System.out.println("Set used(ms):" + (end.getTime() - start.getTime()));
			
			start = new Date();
			for (int i = 0; i < 10000; i++) {
				String v = jedis.get(i + "");
			}
			end = new Date();
			System.out.println("Get used(ms):" + (end.getTime() - start.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jedis.disconnect();

	}

}