package cn.segema.learn.interview.designmode.creational.factorymethod;

public class FileLog implements Log {

	@Override
	public void writeLog() {
		System.out.println("this is file log!");
	}
}