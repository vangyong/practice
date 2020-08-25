package cn.segema.learn.safe.hello;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
* @description 访问private属性和方法
* @author wangyong
* @createDate 2020/08/24
*/
public class AccessPrivateDemo {

    public static void main(String[] args) throws Exception {
        
        ExamDomain e = new ExamDomain();
        Field field1 = e.getClass().getDeclaredField("field1");
        Field field2 = e.getClass().getDeclaredField("field2");
        field1.setAccessible(true);
        System.out.println("field1: " + field1.get(e));
        field1.set(e, "重新设置一个field1值");
        System.out.println("field1: " + field1.get(e));
        System.out.println("field2: " + field2.get(e));
        field2.set(e, "重新设置一个field2值");
        System.out.println("field2: " + field2.get(e));

        Method method1 = e.getClass().getDeclaredMethod("fun1");
        method1.invoke(e);

        Method method2 = e.getClass().getDeclaredMethod("fun2");
        method2.setAccessible(true);
        method2.invoke(e);

        Method method3 = e.getClass().getDeclaredMethod("fun3", String.class);
        method3.setAccessible(true);
        method3.invoke(e, "fun3的参数");
    }

}
