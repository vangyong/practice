package cn.segema.learn.interview.designmode.creational.factorymethod;

public class DatabaseLog implements Log {
	@Override
	public void writeLog() {
		System.out.println("this is database log!");
	}
}
