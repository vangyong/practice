package cn.segema.learn.interview.designmode.creational.factorymethod;

/**
 * @description 工厂方法
 * @author wangyong
 * @createDate 2020/08/25
 */
public class FactoryMethodDemo {
	public static void main(String[] args) {
//		LogFactory logFactory = new DatabaseLogFactory();
//		Log log = logFactory.createLog();
//		log.writeLog();

		 LogFactory logFactory = new FileLogFactory();
		 Log log = logFactory.createLog();
		 log.writeLog();
	}

}
