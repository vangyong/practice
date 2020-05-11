package cn.segema.learn.interview.designmode.creational.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
* @description 一句话描述该类的功能
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
}
