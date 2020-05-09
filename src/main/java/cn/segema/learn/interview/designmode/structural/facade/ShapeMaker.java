 package cn.segema.learn.interview.designmode.structural.facade;

 /**
 * @description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/05/09
 */
 public class ShapeMaker {
     private Shape circle;
     private Shape rectangle;
     private Shape square;
   
     public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
     }
   
     public void drawCircle(){
        circle.draw();
     }
     public void drawRectangle(){
        rectangle.draw();
     }
     public void drawSquare(){
        square.draw();
     }
  }
