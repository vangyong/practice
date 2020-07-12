 package cn.segema.learn.netty.heartbeat;

 /**
 * @description 配置项
 * @author wangyong
 * @createDate 2020/05/21
 */
 public interface TypeData {

     byte PING = 1;

     byte PONG = 2;  
     //顾客
     byte CUSTOMER = 3;
 }
