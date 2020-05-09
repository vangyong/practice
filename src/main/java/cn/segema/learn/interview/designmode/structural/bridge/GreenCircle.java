 package cn.segema.learn.interview.designmode.structural.bridge;

 /**@description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/05/09
 */
 public class GreenCircle implements DrawAPI {
     @Override
     public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
           + radius +", x: " +x+", "+ y +"]");
     }
  }
