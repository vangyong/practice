package cn.segema.learn.interview.designmode.creational.simplefactory;

/**
 * @description 简单工厂
 * @author wangyong
 * @createDate 2020/08/25
 */
public class SimpleFactoryDemo {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Product product = factory.createProduct("B");
        product.use();
    }

}
