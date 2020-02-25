package cn.segema.learn.interview.connectionpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPoolDemo {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/mytest";
	// 数据库的用户名与密码
	static final String USER = "root";
	static final String PASS = "root";
	
	public static void main(String[] args) {
		ConnectionPool connectionPool =new ConnectionPool(JDBC_DRIVER,DB_URL,USER,PASS);
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = connectionPool.getConnection();
			// 执行查询
			System.out.println(" 实例化Statement对象...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT user_id, user_name, mobile_number FROM tb_user";
			ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String mobileNumber = rs.getString("mobile_number");

				// 输出数据
				System.out.print("ID: " + userId);
				System.out.print(", 名称: " + userName);
				System.out.print(", 手机号: " + mobileNumber);
				System.out.print("\n");
			}
			// 完成后关闭
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// 处理 JDBC 错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // 什么都不做
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
		
	}

}
