 package cn.segema.learn.interview.designmode.behavioral.responsibilitychain;

 /**
 * @description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/05/09
 */
 public class FileLogger extends AbstractLogger {
     
     public FileLogger(int level){
        this.level = level;
     }
   
     @Override
     protected void write(String message) {    
        System.out.println("File::Logger: " + message);
     }
  }
