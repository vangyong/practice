 package cn.segema.learn.interview.designmode.behavioral.responsibilitychain;

 /**
 * @description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/05/09
 */
 public class ConsoleLogger extends AbstractLogger {
     
     public ConsoleLogger(int level){
        this.level = level;
     }
   
     @Override
     protected void write(String message) {    
        System.out.println("Standard Console::Logger: " + message);
     }
  }
