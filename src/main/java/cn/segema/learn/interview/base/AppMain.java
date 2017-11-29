package cn.segema.learn.interview.base;


import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AppMain {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();

        Map map2 = new ConcurrentHashMap();

        Hashtable hashtable = new Hashtable();


        Collections.synchronizedMap(map);

    }

    public synchronized void test1() {

    }

    ReentrantLock;

}
