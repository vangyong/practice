package cn.segema.learn.framework.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {

	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSession getSqlSession() {
		try {
			InputStream inputStream = Resources.getResourceAsStream("cn/segema/learn/framework/mybatis/mybatis.xml");
			if (sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); // build()方法会把inputStream关闭掉
			} else {
				inputStream.close();
			}
			return sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
