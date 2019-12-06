package cn.segema.learn.interview.design.behavior.observe;

public interface Observable {
	//注册观察者 
	void registerObserver(Observer observer); 
	//移除观察者 
	void removeObserver(Observer observer); 
	/** * 主题状态改变-->通知所有注册的观察者 
	 * * @param message 通知的消息 */ 
	void notifyObservers(String message);


}
