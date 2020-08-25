package cn.segema.learn.interview.concurrent.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
* @description atomicReference 如果引用相等，则设置一个新的引用
* @author wangyong
* @createDate 2020/08/25
*/
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        String initialReference = "initial value referenced";

        AtomicReference<String> atomicStringReference = new AtomicReference<String>(initialReference);

        String newReference = "new value referenced";
        boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);

        exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);
    }

}
