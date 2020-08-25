package cn.segema.learn.interview.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter {

    private AtomicInteger count = new AtomicInteger();

    public AtomicIntegerCounter() {}

    public int getCount() {
        return count.get();
    }

    public void increase() {
        count.getAndIncrement();
    }

}
