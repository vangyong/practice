package cn.segema.learn.interview.jdk8;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @description Supplier创建对象
 * @author wangyong
 * @createDate 2020/09/17
 */
public class SupplierDemo {
    private int age;

    SupplierDemo() {
        age = new Random(1).nextInt(10);
        System.out.println(age);
    }

    public static void main(String[] args) {
        // 创建Supplier容器，声明为SupplierDemo类型，此时并不会调用对象的构造方法，即不会创建对象
        Supplier<SupplierDemo> supplier = SupplierDemo::new;
        System.out.println("--------");
        // 调用get()方法，此时会调用对象的构造方法，即获得到真正对象
        supplier.get();
        // 每次get都会调用构造方法，即获取的对象不同
        supplier.get();
    }

}
