package cn.segema.learn.interview.base;

public class OrderExample {
	int a = 0;
	boolean flag = false;

	public synchronized void writer() {
	    a = 1;                   
	    flag = true;           
	}

	public synchronized void reader() {
	    if (flag) {                
	        int i =  a +1;   
	        
	    }
	}

}
