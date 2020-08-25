package cn.segema.learn.interview.designmode.creational.singleton;

/**
 * @description 饿汉变种实现
 * @author wangyong
 * @createDate 2020/05/11
 */
public class Hungry2Singleton {

    private static Hungry2Singleton instance = null;
    static {
        instance = new Hungry2Singleton();
    }

    private Hungry2Singleton() {}

    public static Hungry2Singleton getInstance() {
        return instance;
    }

    public String sayHello(String param) {
        System.out.println("param:" + param);
        System.out.println("this is HungrySingleton!");
        return "sayHello";
    }

}
