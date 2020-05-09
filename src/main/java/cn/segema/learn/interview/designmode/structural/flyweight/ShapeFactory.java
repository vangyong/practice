package cn.segema.learn.interview.designmode.structural.flyweight;

import java.util.HashMap;

/**
 * @description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/05/09
 */
public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle)circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}