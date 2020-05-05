package cn.segema.learn.interview.designmode.creational.factorymethod;

public class DatabaseLogFactory implements LogFactory {
	
	@Override
	public Log createLog(){
		return new DatabaseLog();
	}
}