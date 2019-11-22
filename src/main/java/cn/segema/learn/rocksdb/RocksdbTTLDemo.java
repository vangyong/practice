package cn.segema.learn.rocksdb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.rocksdb.BloomFilter;
import org.rocksdb.Filter;
import org.rocksdb.Options;
import org.rocksdb.RateLimiter;
import org.rocksdb.ReadOptions;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.rocksdb.Statistics;
import org.rocksdb.TtlDB;

public class RocksdbTTLDemo {

	static {
		RocksDB.loadLibrary();
	}

	public static void main(final String[] args) throws Exception {

		final String db_path = System.getProperty("user.dir") + "\\dbfile";

		TtlDB db = null;
		
		Options options = new Options();
		options.setCreateIfMissing(true);
		options.setWalTtlSeconds(10);
		options.setLevel0FileNumCompactionTrigger(1);
		options.setMaxCompactionBytes(1);

		try {
			db = TtlDB.open(options, db_path, 10, false);
			db.put("key1".getBytes(), "key1_value".getBytes());
			db.put("key2".getBytes(), "key2_value".getBytes());
			db.put("key3".getBytes(), "key3_value".getBytes());
			db.put("key4".getBytes(), "key4_value".getBytes());
			db.put("key5".getBytes(), "key5_value".getBytes());
			db.put("key6".getBytes(), "key6_value".getBytes());
			db.put("key7".getBytes(), "key7_value".getBytes());

			final byte[] key1Value = db.get("key1".getBytes());
			System.out.println("key1:" + new String(key1Value));

			// 查看状态
			final String rocksdbStats = db.getProperty("rocksdb.stats");
			System.out.println("rocksdb.stats:" + rocksdbStats);
		} catch (final RocksDBException e) {
			System.out.format("Caught the expected exception -- %s\n", e);
		}

	}
}
