package cn.segema.learn.interview.design.observe;

public class LessonStartDemo {
	
	public static void main(String[] args) {
		LessonStartDemo lessonStart = new LessonStartDemo(); 
		Student s1 = new Student(); 
		s1.setName("张三"); 
		Student s2 = new Student(); 
		s2.setName("李四"); 
		Teacher teacher = new Teacher(); 
		//注册两个观察者 
		teacher.registerObserver(s1); 
		teacher.registerObserver(s2); 
		//这里假设主题状态变-->通知观察者更新 
		teacher.notifyObservers("点名啦");


	}

}
