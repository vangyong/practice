package cn.segema.learn.interview.design.create.singleton;

public class SingletonDemo {

	public static void main(String[] args) {
		
//		DoubleCheckSingleton singleton = DoubleCheckSingleton.getInstance();
//		String retStr = singleton.saySingleton("DoubleCheckSingleton param");
//		System.out.println(retStr);
		
//		FactorySingleton  factorySingleton= FactorySingleton.getInstance();
//		factorySingleton.sayHello("factorySingleton param");
		
		
//		HungrySingleton hungrySingleton = HungrySingleton.getInstance();
//		hungrySingleton.sayHello("hungrySingleton param");
		
		
//		LazySingleton lazySingleton = LazySingleton.getInstance();
//		lazySingleton.sayHello("LazySingleton param");
		
		
//		StaticInnerSingleton staticInnerSingleton = StaticInnerSingleton.getInstance();
//		staticInnerSingleton.sayHello("LazySingleton param");
		
		
		SynchronizedSingleton synchronizedSingleton = SynchronizedSingleton.getInstance();
		synchronizedSingleton.sayHello("SynchronizedSingleton param");

	}

}
