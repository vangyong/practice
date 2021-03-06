package cn.segema.learn.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;


/**
 * @description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/05/06
 * @see https://www.cnblogs.com/rocky-fang/p/9030438.html
 */
public class ZookeeperConnectionDemo implements Watcher {
    
	private static CountDownLatch countDownLatch = new CountDownLatch(1);

	public void process(WatchedEvent event) {
		System.out.println("receive the event:" + event);
		if (Event.KeeperState.SyncConnected == event.getState())
			countDownLatch.countDown();
	}

	public static final String ADDRESS = "10.10.143.147:2181";

	public static void main(String[] args) throws IOException {
		ZooKeeper zooKeeper = new ZooKeeper(ADDRESS, 5000, new ZookeeperConnectionDemo());
		System.out.println(zooKeeper.getState());
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("zookeeper session established");
	}
}
