package cn.segema.learn.framework.myibatis;

import java.lang.reflect.Proxy;

public class SqlSession {
	// 获取getMapper
	public static <T> T getMapper(Class<T> clas)
			throws IllegalArgumentException, InstantiationException, IllegalAccessException {
		return (T) Proxy.newProxyInstance(clas.getClassLoader(), new Class[] { clas },
				new MyInvocationHandlerMbatis(clas));
	}
}
