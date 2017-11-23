package cn.segema.learn.interview.exceptions;

import java.sql.SQLException;

public class TestException {

	public static void main(String[] args) {
		try {
			System.out.println("打开连接");
		} finally {
			try {
				System.out.println("测试是否开启");
				testThrowExcetion();
			} catch (SQLException e) {
				throw new StoreException(e);
			}
			
			System.out.println("第一层finally");
			
		}
	}
	
	public static void testThrowExcetion() throws SQLException {
		System.out.println("testThrowExcetion");
		SQLException SQLException = new SQLException(); 
		throw SQLException;
	}

}
