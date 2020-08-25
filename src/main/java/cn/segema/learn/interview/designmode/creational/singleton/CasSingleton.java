package cn.segema.learn.interview.designmode.creational.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
* @description cas自旋式单例
* @author wangyong
* @createDate 2020/05/11
*/
public class CasSingleton {
    private static final AtomicReference<CasSingleton> instance = new AtomicReference<CasSingleton>();

    private CasSingleton() {}

    public static CasSingleton getInstance() {
        for (;;) {
            CasSingleton singleton = instance.get();
            if (null != singleton) {
                return singleton;
            }
            singleton = new CasSingleton();
            if (instance.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }
    
    
    public String sayHello(String param) {
        System.out.println("param:" + param);
        System.out.println("this is CasSingleton!");
        return "sayHello";
    }
}
