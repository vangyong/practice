 package cn.segema.learn.interview.designmode.structural.decorator;

 /**@description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/05/09
 */
 public class Circle implements Shape {
     
     @Override
     public void draw() {
        System.out.println("Shape: Circle");
     }
  }
