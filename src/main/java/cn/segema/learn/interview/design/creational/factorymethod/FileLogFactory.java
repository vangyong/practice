package cn.segema.learn.interview.design.creational.factorymethod;

public class FileLogFactory implements LogFactory{

	@Override
	public Log createLog() {
		return new FileLog();
	}
}