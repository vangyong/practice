package cn.segema.learn.interview.designmode.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Teacher implements Observable {

	// 用一个集合来存储所有的观察者
	private List<Observer> mObserverList;

	public Teacher() {
		mObserverList = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer observer) {
		// 向集合中添加观察者
		mObserverList.add(observer);

	}

	@Override
	public void removeObserver(Observer observer) {
		mObserverList.remove(observer);
	}

	@Override
	public void notifyObservers(String message) {
		// 遍历集合通知所有的观察者，自身数据变化了
		for (Observer observer : mObserverList) {
			observer.update(message);
		}

	}

}
