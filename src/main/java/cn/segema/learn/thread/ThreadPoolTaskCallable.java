package cn.segema.learn.thread;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;

import cn.segema.learn.interview.design.facade.User;

public class ThreadPoolTaskCallable implements Callable<List<User>> {

	@Override
	public List<User> call() throws Exception {
		List<User> list = new CopyOnWriteArrayList<User>();
		System.out.println(Thread.currentThread().getName()+"：运行");
		return list;
	}

}
