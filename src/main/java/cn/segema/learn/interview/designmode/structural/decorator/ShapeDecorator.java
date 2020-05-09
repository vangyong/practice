 package cn.segema.learn.interview.designmode.structural.decorator;

 /**@description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/05/09
 */
 public abstract class ShapeDecorator implements Shape {
     protected Shape decoratedShape;
   
     public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
     }
   
     public void draw(){
        decoratedShape.draw();
     }  
  }
