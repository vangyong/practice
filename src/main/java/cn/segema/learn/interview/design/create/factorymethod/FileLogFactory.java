package cn.segema.learn.interview.design.create.factorymethod;

public class FileLogFactory implements LogFactory{

	@Override
	public Log createLog() {
		return new FileLog();
	}
}