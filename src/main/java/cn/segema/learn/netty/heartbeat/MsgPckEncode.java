package cn.segema.learn.netty.heartbeat;

import org.msgpack.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @description 编码器
 * @author wangyong
 * @createDate 2020/05/21
 */
public class MsgPckEncode extends MessageToByteEncoder<Object> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf buf) throws Exception {
        MessagePack pack = new MessagePack();
        byte[] write = pack.write(msg);
        buf.writeBytes(write);
    }
}
