package cn.segema.learn.interview.designmode.creational.singleton;

/**
* @description 一句话描述该类的功能
* @author wangyong
* @createDate 2020/05/11
* @link https://www.ershicimi.com/p/a406bbe794f02f4a790173a68f75190e
*/
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> singleton = new ThreadLocal<ThreadLocalSingleton>() {
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static ThreadLocalSingleton getInstance() {
        return singleton.get();
    }

    private ThreadLocalSingleton() {}
}
