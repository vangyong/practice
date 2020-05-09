 package cn.segema.learn.interview.designmode.structural.facade;

 /**
 * @description 外观模式
 * @author wangyong
 * @createDate 2020/05/09
 */
 public class FacadePatternDemo {
     public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
   
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();      
     }
  }
