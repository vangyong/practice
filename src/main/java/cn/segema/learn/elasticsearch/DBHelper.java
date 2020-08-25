package cn.segema.learn.elasticsearch;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @description 数据库连接
 * @author wangyong
 * @createDate 2020/08/25
 */
public class DBHelper {
    public static final String url = "jdbc:mysql://127.0.0.1:3306/mytest?useSSL=true";
    public static final String name = "com.mysql.cj.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "root";

    public static Connection conn = null;

    public static Connection getConn() {
        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, password);// 获取连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
