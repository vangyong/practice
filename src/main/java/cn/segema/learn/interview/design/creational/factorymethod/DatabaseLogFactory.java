package cn.segema.learn.interview.design.creational.factorymethod;

public class DatabaseLogFactory implements LogFactory {
	
	@Override
	public Log createLog(){
		return new DatabaseLog();
	}
}