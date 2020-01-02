package cn.segema.learn.interview.jdbcpool;

/**
 * 静态内部类实现连接池的单例
 */
public class PoolManager {

	private static class CreatePool {
		private static JdbcPool pool = new JdbcPool();
	}

	public static JdbcPool getInstance() {
		return CreatePool.pool;
	}

}
