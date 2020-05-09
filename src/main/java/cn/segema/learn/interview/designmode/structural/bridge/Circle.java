 package cn.segema.learn.interview.designmode.structural.bridge;

 /**@description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/05/09
 */
 public class Circle extends Shape {
     private int x, y, radius;
   
     public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;  
        this.y = y;  
        this.radius = radius;
     }
   
     public void draw() {
        drawAPI.drawCircle(radius,x,y);
     }
  }
