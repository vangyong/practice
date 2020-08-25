package cn.segema.learn.interview.designmode.creational.prototype;

/**
* @description 正方形
* @author wangyong
* @createDate 2020/08/25
*/
public class Square extends Shape {
    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
