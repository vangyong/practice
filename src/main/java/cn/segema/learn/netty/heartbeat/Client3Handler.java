 package cn.segema.learn.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;

/**
 * @description 客户端的handler控制器
 * @author wangyong
 * @createDate 2020/05/21
 */
 public class Client3Handler extends Middleware {

     private Client client;

     public Client3Handler(Client client) {
         super("client");
         this.client = client;
     }

     @Override
     protected void handlerData(ChannelHandlerContext ctx, Object msg) {
         Model model = (Model) msg;
         System.out.println("client  收到数据： " + model.toString());
     }
     @Override
     protected void handlerAllIdle(ChannelHandlerContext ctx) {
         super.handlerAllIdle(ctx);
         sendPingMsg(ctx);
     }   
     @Override
     public void channelInactive(ChannelHandlerContext ctx) throws Exception {
         super.channelInactive(ctx);
         client.doConnect();
     }
     @Override
     public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
             throws Exception {      
         System.out.println(name + "exception :"+ cause.toString());
     }
 }
