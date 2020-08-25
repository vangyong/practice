package cn.segema.learn.interview.designmode.creational.singleton;

/**
 * @description 懒汉式单例
 * @author wangyong
 * @createDate 2020/05/09
 */
public class LazySingleton {

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static LazySingleton instance = null;

    /* 私有构造方法，防止被实例化 */
    private LazySingleton() {}

    /* 静态工程方法，创建实例 */
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return instance;
    }

    public String sayHello(String param) {
        System.out.println("param:" + param);
        System.out.println("this is LazySingleton!");
        return "sayHello";
    }

}
