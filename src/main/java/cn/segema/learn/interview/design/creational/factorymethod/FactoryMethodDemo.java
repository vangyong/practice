package cn.segema.learn.interview.design.creational.factorymethod;

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
