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


        String s0 ="MDFG";
        String s1 ="MD"+"FG";
        String s2 = new String("MDFG");

        System.out.println(s0==s1);
        System.out.println(s0==s2);
        System.out.println(s1==s2);

        s1 = s1.intern();
        s2 = s2.intern();

        System.out.println(s0==s1);
        System.out.println(s0==s2);
        System.out.println(s1==s2);
    }



}
