package cn.segema.learn.rocksdb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class RocksdbDemo {

	static {
		RocksDB.loadLibrary();
	}

	public static void main(final String[] args) throws Exception {

		final String db_path = System.getProperty("user.dir") + "\\dbfile";

		RocksDB db = null;

		// final Options options = new Options();
		// final Filter bloomFilter = new BloomFilter(10);
		// final ReadOptions readOptions = new ReadOptions().setFillCache(false);
		// final Statistics stats = new Statistics();
		// final RateLimiter rateLimiter = new RateLimiter(10000000, 10000, 10);
		try {
			db = RocksDB.open(db_path);
			db.put("hello".getBytes(), "world".getBytes());
			final byte[] helloValue = db.get("hello".getBytes());
			System.out.println("hello:" + new String(helloValue));
			
			//存入大文件测试
			File f1in = new File("E:\\test\\test1.exe");
			long fileSize = f1in.length();
			InputStream inputStream = new FileInputStream(f1in);
//			int byteread = 0;
//			byte[] tempbytes = new byte[1024];
//			while ((byteread = inputStream.read(tempbytes)) != -1) {  
//			    System.out.write(tempbytes, 0, byteread);  
//			}  
			
			byte[] inf1bytes = new byte[(int) fileSize];
			inputStream.read(inf1bytes);
			inputStream.close();
			db.put("f1".getBytes(), inf1bytes);
			
			//读出文件写入下载目录
			final byte[] outf1bytes = db.get("f1".getBytes());
			File f1out = new File("E:\\test_down\\test1.exe");
			OutputStream outputStream = new FileOutputStream(f1out); 
			outputStream.write(outf1bytes); 
			outputStream.flush();  
			outputStream.close(); 
			
			//查看状态
			final String rocksdbStats = db.getProperty("rocksdb.stats");
			System.out.println("rocksdb.stats:" + rocksdbStats);
		} catch (final RocksDBException e) {
			System.out.format("Caught the expected exception -- %s\n", e);
		}

	}
}
