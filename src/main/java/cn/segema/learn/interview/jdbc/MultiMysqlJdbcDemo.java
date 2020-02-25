package cn.segema.learn.interview.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;

public class MultiMysqlJdbcDemo {
	static final int threadSize = 2;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/mytest";
	// 数据库的用户名与密码
	static final String USER = "root";
	static final String PASS = "root";

	static CountDownLatch countDownLatch1 = new CountDownLatch(1);
	static CountDownLatch countDownLatch2 = new CountDownLatch(threadSize);

	public static void main(String[] args) throws InterruptedException {
		threadTest();
	}

	public static void threadTest() throws InterruptedException {
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < threadSize; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						// 使得线程阻塞到coutDownLatch1为0时才执行
						countDownLatch1.await();
						select();
						// 每个独立子线程执行完后，countDownLatch2减1
						countDownLatch2.countDown();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		// 将countDownLatch1置为0，从而使线程并发执行
		countDownLatch1.countDown();

		// 等待countDownLatch2变为0时才继续执行
		countDownLatch2.await();
		long time2 = System.currentTimeMillis();

		System.out.println("thread size: " + threadSize + " no use pool :" + (time2 - time1));
	}

	public static void select() throws SQLException {

		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement sm = null;
		ResultSet rs = null;
		try {
			sm = conn.createStatement();
			rs = sm.executeQuery("select * from tb_user");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				System.out.println(Thread.currentThread().getName());
				System.out.println("ID: " +rs.getInt("user_id"));
				System.out.println("NAME: " +rs.getString("user_name"));
				System.out.println("MOBILE: " +rs.getString("mobile_number"));
				System.out.print("\n");
			}
			Thread.sleep(100);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		rs.close();
		sm.close();
		conn.close();
	}

}
