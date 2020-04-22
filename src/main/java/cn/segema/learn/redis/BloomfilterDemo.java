package cn.segema.learn.redis;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;
import redis.clients.jedis.Jedis;

/**
 * 布隆过滤器解决缓存击穿
 * 
 * @author wangyong
 *
 */
public class BloomfilterDemo {

	private static int size = 1000000;
	private static BloomFilter<String> bloomFilter = BloomFilter.create(new Funnel<String>() {
		private static final long serialVersionUID = 1L;

		public void funnel(String arg0, PrimitiveSink arg1) {
			arg1.putString(arg0, Charsets.UTF_8);
		}
	}, size);

	static String key = "bloomfilter_key";

	public static void main(String[] args) {
		for (int i = 0; i < size; i++) {
			if (i == 5) {
				bloomFilter.put(String.valueOf("bloomfilter_key"));
			}
			bloomFilter.put(String.valueOf(i));
		}

		Jedis jedis = new Jedis("127.0.0.1");
		jedis.auth("123456");

		String value = jedis.get(key);
		if (value == null) {
			if (!bloomFilter.mightContain(key)) {
				System.out.println(value);
			} else {
				value = getFromDB(key);
				jedis.set(key, value);
			}
		}else{
			System.out.println(value);
		}
	}

	public static String getFromDB(String key) {
		return "db_key_value";
	}

}
