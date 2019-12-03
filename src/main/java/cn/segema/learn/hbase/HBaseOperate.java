package cn.segema.learn.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Before;
import org.junit.Test;

public class HBaseOperate {

	private Configuration conf = null;

	@Before
	public void connect() {
		conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "master,slave1,slave2");
		conf.set("hbase.zookeeper.property.clientPort", "2181");
	}

	/**
	 * 创建表
	 * 
	 * @throws Exception
	 * @throws IOException
	 */

	@Test
	public void createTable() throws Exception {
		HBaseAdmin admin = new HBaseAdmin(conf);
		HTableDescriptor desc = new HTableDescriptor(TableName.valueOf("teacher"));
		desc.addFamily(new HColumnDescriptor("info"));
		desc.addFamily(new HColumnDescriptor("zhicheng"));
		admin.createTable(desc);
		admin.close();
	}

	@Test
	public void putToTable() throws IOException {
		// 创建表对象
		HTable table = new HTable(conf, "teacher");
		// 创建put对象
		Put put = new Put("l00002".getBytes());
		put.add("info".getBytes(), "name".getBytes(), "san".getBytes());
		table.put(put);
		table.close();
	}

	/**
	 * 判断表是否存在
	 * 
	 * @throws MasterNotRunningException
	 * @throws ZooKeeperConnectionException
	 * @throws IOException
	 */

	@Test
	public void isExist() throws MasterNotRunningException, ZooKeeperConnectionException, IOException {
		HBaseAdmin admin = new HBaseAdmin(conf);
		boolean re = admin.tableExists("student");
		System.out.println(re);
		admin.close();
	}

	// 删除行

	@Test
	public void deleteRow() throws IOException {
		HTable table = new HTable(conf, "teacher");
		Delete delete = new Delete("100002".getBytes());
		table.delete(delete);
		table.close();
	}

	@Test
	public void scanTable() throws IOException {
		HTable table = new HTable(conf, "teacher");
		Scan scan = new Scan();
		ResultScanner rs = table.getScanner(scan);
		for (Result r : rs) {
			Cell[] cs = r.rawCells();
			for (Cell c : cs) {
				System.out.print("行键" + Bytes.toString(CellUtil.cloneRow(c)) + "\t");
				System.out.print("列族" + Bytes.toString(CellUtil.cloneFamily(c)));
				System.out.print("列" + Bytes.toString(CellUtil.cloneRow(c)) + "\t");
				System.out.println("值" + Bytes.toString(CellUtil.cloneValue(c)));
			}
		}
	}

	@Test
	public void getRow() throws IOException {
	HTable table = new HTable(conf, "teacher");
	Get get = new Get("100001".getBytes());
	Result rs = table.get(get);                                                                                                                                                                                                       
	Cell[] cs = rs.rawCells();
	for (Cell c : cs) {
	System.out.print("行键"+ Bytes.toString(CellUtil.cloneRow(c))+"\t");
	System.out.print("列族"+Bytes.toString(CellUtil.cloneFamily(c)));
	System.out.print("列"+Bytes.toString(CellUtil.cloneRow(c))+"\t");
	System.out.println("值"+Bytes.toString(CellUtil.cloneValue(c)));
	}
	}

}
