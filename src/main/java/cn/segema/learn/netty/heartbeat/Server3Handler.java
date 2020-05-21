 package cn.segema.learn.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;

/**
 * @description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/05/21
 */
public class Server3Handler extends Middleware{
    public Server3Handler() {
        super("server");
    }
    @Override
    protected void handlerData(ChannelHandlerContext ctx, Object msg) {
        Model model  = (Model) msg;
        System.out.println("server 接收数据 ： " +  model.toString());   
            model.setType(TypeData.CUSTOMER);
            model.setBody("---------------");
            ctx.channel().writeAndFlush(model);         
            System.out.println("server 发送数据： " + model.toString()); 
    }
    @Override
    protected void handlerReaderIdle(ChannelHandlerContext ctx) {
        super.handlerReaderIdle(ctx);
        System.err.println(" ---- client "+ ctx.channel().remoteAddress().toString() + " reader timeOut, --- close it");
        ctx.close();
    }   
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        System.err.println( name +"  exception" + cause.toString());
    }  
}
