 package cn.segema.learn.interview.designmode.structural.decorator;

 /**@description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/05/09
 */
 public class RedShapeDecorator extends ShapeDecorator {
     
     public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);     
     }
   
     @Override
     public void draw() {
        decoratedShape.draw();         
        setRedBorder(decoratedShape);
     }
   
     private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
     }
  }
