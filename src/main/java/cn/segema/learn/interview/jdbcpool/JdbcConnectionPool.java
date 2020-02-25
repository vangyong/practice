package cn.segema.learn.interview.jdbcpool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

public class JdbcConnectionPool {

	private static String jdbcDriver;

	private static String jdbcUrl;

	private static String username;

	private static String password;

	private static Integer initConnectCount;

	private static Integer maxConnects;

	private static Integer incrementCount;

	private static Vector<JdbcConnection> connections = new Vector<>();

	static {
		InputStream is = JdbcConnectionPool.class.getClassLoader().getResourceAsStream("application.properties");
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		jdbcDriver = properties.getProperty("jdbc.driver");
		jdbcUrl = properties.getProperty("jdbc.url");
		username = properties.getProperty("jdbc.username");
		password = properties.getProperty("jdbc.password");
		initConnectCount = Integer.valueOf(properties.getProperty("jdbc.initConnectCount"));
		maxConnects = Integer.valueOf(properties.getProperty("jdbc.maxConnects"));
		incrementCount = Integer.valueOf(properties.getProperty("jdbc.incrementCount"));

		try {

			Driver driver = (Driver) Class.forName(jdbcDriver).newInstance();
			DriverManager.registerDriver(driver);
			createConnections(initConnectCount);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取可用连接
	 */
	public JdbcConnection getConnection() {
		if (connections.isEmpty()) {
			System.out.println("连接池中没有连接");
			throw new RuntimeException("连接池中没有连接");
		}
		return getActiveConnection();
	}

	/**
	 * 同步方法来获取连接池中可用连接，在多线程情况下， 只有一个线程访问该方法来获取连接，防止由于多线程情况下多个线程获取同一个连接从而引起出错
	 * 
	 * @return
	 */
	private synchronized JdbcConnection getActiveConnection() {
		// 若获取不到可用连接,则依靠无限循环来继续获取
		while (true) {
			for (JdbcConnection con : connections) {
				if (!con.isUse()) {
					Connection trueConn = con.getConn();
					try {
						// 验证连接是否失效,0表示校验超时
						if (!trueConn.isValid(0)) {
							con.setConn(DriverManager.getConnection(jdbcUrl, username, password));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					con.setUse(true);
					return con;
				}
			}

			// 根据连接池中连接数量从而判断是否增加对应的数量的连接
			if (connections.size() <= maxConnects - incrementCount) {
				createConnections(incrementCount);
			} else if (connections.size() < maxConnects && connections.size() > maxConnects - incrementCount) {
				createConnections(maxConnects - connections.size());
			}
		}
	}

	/**
	 * 创建对应数量的连接并放入连接池中
	 * 
	 * @param count
	 */
	private static void createConnections(int count) {
		for (int i = 0; i < count; i++) {
			if (maxConnects > 0 && connections.size() >= maxConnects) {
				System.out.println("连接池中连接数量已经达到最大值");
				throw new RuntimeException("连接池中连接数量已经达到最大值");
			}
			try {
				Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
				//将连接放入连接池中,并将状态设为可用
				connections.add(new JdbcConnection(connection, false));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int getSize() {
		return connections.size();
	}

}
