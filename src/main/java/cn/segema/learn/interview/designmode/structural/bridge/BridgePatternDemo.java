 package cn.segema.learn.interview.designmode.structural.bridge;

 /**@description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/05/09
 */
 public class BridgePatternDemo {
     public static void main(String[] args) {
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());
   
        redCircle.draw();
        greenCircle.draw();
     }
  }
