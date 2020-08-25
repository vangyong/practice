package cn.segema.learn.interview.designmode.creational.prototype;

/**
* @description 原型模式
* @author wangyong
* @createDate 2020/08/25
*/
public class PrototypeDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape = (Shape)ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape)ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape)ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}
