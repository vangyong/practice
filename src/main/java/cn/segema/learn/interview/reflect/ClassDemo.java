package cn.segema.learn.interview.reflect;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description [一句话描述该类的功能]
 * @author wangyong
 * @CreateDate 2020/04/24
 */
public class ClassDemo {
    public static void main(String[] args) throws Exception {

        //通过实例获取Class对象
        Class c1 = "foo".getClass();
        byte[] bytes = new byte[1024];
        Class c2 = bytes.getClass();
        Set<String> s = new HashSet<String>();
        Class c3 = s.getClass();

        // 通过类的类型获取Class对象
        Class c4 = boolean.class;
        Class c5 = String.class;

        // 类的全限定名获取Class对象
        Class c6 = Class.forName("java.lang.String");
        Class cDoubleArray = Class.forName("[D");
        Class cStringArray = Class.forName("[[Ljava.lang.String;");
        
        //包装类可以使用TYPE字段获取
        Class cDouble = Double.TYPE;   //等价于 double.class
        Class cVoid = Void.TYPE;

    }

}
