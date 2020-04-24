package cn.segema.learn.interview.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo {

    public static void main(String[] args) {
        Class<?> c = Cat.class;
        try {
            // 构造Cat实例
            Constructor<?> constructor = c.getConstructor(String.class, int.class);
            Object cat = constructor.newInstance("Jack", 3);
            
            // 调用无参方法
            Method sleep = c.getDeclaredMethod("sleep");
            sleep.invoke(cat);
            
            // 调用定项参数方法
            Method eat = c.getDeclaredMethod("eat", String.class);
            eat.invoke(cat, "grass");
            
            //调用不定项参数方法, 不定项参数可以当成数组来处理
            Class[] argTypes = new Class[] {String[].class};
            Method varargsEat = c.getDeclaredMethod("eat", argTypes);
            String[] foods = new String[] {"grass", "meat"};
            varargsEat.invoke(cat, (Object)foods);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException
            | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
