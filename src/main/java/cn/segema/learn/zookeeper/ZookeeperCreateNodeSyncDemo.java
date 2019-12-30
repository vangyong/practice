package cn.segema.learn.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class ZookeeperCreateNodeSyncDemo implements Watcher {
	private static final CountDownLatch countDownLatch = new CountDownLatch(1);
	private static final String ADDRESS = "192.168.0.151:2181";
	private static final String PREFIX = "/mytest-sync-create-";

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		ZooKeeper zooKeeper = new ZooKeeper(ADDRESS, 5000, new ZookeeperCreateNodeSyncDemo());
		System.out.println("state:" + zooKeeper.getState());
		countDownLatch.await();
		String path1 = zooKeeper.create(PREFIX, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		System.out.println("success create znode:" + path1);
		String path2 = zooKeeper.create(PREFIX, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL_SEQUENTIAL);
		System.out.println("success create znode:" + path2);
		zooKeeper.close();
	}

	public void process(WatchedEvent event) {
		// 连上了
		if (Event.KeeperState.SyncConnected == event.getState())
			countDownLatch.countDown();
	}
}
