package cn.segema.learn.interview.threadlocal;

public class ThreadLocal {
	
	private ThreanLocalMap tm = new ThreanLocalMap();//模拟ThreadLocalMap。
	
	
	public void set(BigByte bigByte , byte[] value){
		tm.put(bigByte, value);
	}


	public ThreanLocalMap getTm() {
		return tm;
	}
	
	
}
