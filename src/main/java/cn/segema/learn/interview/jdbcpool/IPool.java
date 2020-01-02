package cn.segema.learn.interview.jdbcpool;

import java.sql.Connection;

public interface IPool {
	// 获取连接池中可用连接
	ConnectionPool getConnection();

	// 获取一个数据库连接（不使用连接池）
	Connection getConnectionNoPool();

}
