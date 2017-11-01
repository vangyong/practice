package cn.segema.learn.interview.design.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerPattern {
	 public static void main(String args[]){
	     BlockingQueue sharedQueue = new LinkedBlockingQueue();
	     Thread prodThread = new Thread(new Producer(sharedQueue));
	     Thread consThread = new Thread(new Consumer(sharedQueue));
	     prodThread.start();
	     consThread.start();
	    }
}
