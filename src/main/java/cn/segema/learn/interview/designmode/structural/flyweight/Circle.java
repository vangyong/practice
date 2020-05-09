 package cn.segema.learn.interview.designmode.structural.flyweight;

 /**
 * @description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/05/09
 */
 public class Circle implements Shape {
     private String color;
     private int x;
     private int y;
     private int radius;
   
     public Circle(String color){
        this.color = color;     
     }
   
     public void setX(int x) {
        this.x = x;
     }
   
     public void setY(int y) {
        this.y = y;
     }
   
     public void setRadius(int radius) {
        this.radius = radius;
     }
   
     @Override
     public void draw() {
        System.out.println("Circle: Draw() [Color : " + color 
           +", x : " + x +", y :" + y +", radius :" + radius);
     }
  }
