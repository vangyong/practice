package cn.segema.learn.clickhouse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClickhouseDemo {

	public static void main(String[] args) {

		try {
			Class.forName("com.github.housepower.jdbc.ClickHouseDriver");
			Connection connection = DriverManager.getConnection("jdbc:clickhouse://10.10.19.201:9000/NTA_DB","default","swad@clickhouse");

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT guid,`command.server`,`command.file_no` FROM FTP_CMD_LOG where 1=1  and (log_date >='2019-12-02'  and log_time >=1575277200) and (log_date <='2019-12-03' and log_time<=1575363475) limit 0,20 ");

			while (rs.next()) {
				System.out.println(rs.getBigDecimal(1) + "\t");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
