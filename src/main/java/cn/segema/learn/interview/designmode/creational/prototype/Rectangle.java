package cn.segema.learn.interview.designmode.creational.prototype;

/**
* @description 长方形
* @author wangyong
* @createDate 2020/08/25
*/
public class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
