package cn.segema.learn.interview.jdk7.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Test08 {
	public static void main(String[] args) throws Exception {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Integer> result = forkJoinPool.submit(new Calculator(1, 10000));
        System.out.println(result.get());
    }
}
