package cn.segema.learn.interview.designmode.creational.singleton;

/**
 * @description 饿汉式单例
 * @author wangyong
 * @createDate 2020/05/11
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }

    public String sayHello(String param) {
        System.out.println("param:" + param);
        System.out.println("this is HungrySingleton!");
        return "sayHello";
    }

}
