package cn.segema.learn.interview.jdbcpool;

/**
 * 静态内部类实现连接池的单例
 */
public class JdbcConnectionPoolManager {

	private static class CreatePool {
		private static JdbcConnectionPool jdbcConnectionPool = new JdbcConnectionPool();
	}

	public static JdbcConnectionPool getInstance() {
		return CreatePool.jdbcConnectionPool;
	}

}
