package cn.segema.learn.interview.design.creational.factorymethod;

public class FileLog implements Log {

	@Override
	public void writeLog() {
		System.out.println("this is file log!");
	}
}