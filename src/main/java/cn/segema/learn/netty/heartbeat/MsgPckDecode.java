package cn.segema.learn.netty.heartbeat;

import java.util.List;

import org.msgpack.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

/**
 * @description 解码器
 * @author wangyong
 * @createDate 2020/05/21
 */
public class MsgPckDecode extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        final byte[] array;
        final int length = msg.readableBytes();
        array = new byte[length];
        msg.getBytes(msg.readerIndex(), array, 0, length);
        MessagePack pack = new MessagePack();
        out.add(pack.read(array, Model.class));
    }
}
