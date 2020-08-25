package cn.segema.learn.interview.designmode.creational.prototype;

/**
* @description 圆
* @author wangyong
* @createDate 2020/08/25
*/
public class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}