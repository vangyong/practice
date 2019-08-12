package cn.segema.learn.interview.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServerConnDemo {
	public static void main(String[] args) throws IOException {
        // 对应IO编程中服务端启动
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8000));
        serverSocketChannel.configureBlocking(false);
        Selector serverSelector = Selector.open();
        serverSocketChannel.register(serverSelector, SelectionKey.OP_ACCEPT);
        System.out.println("server started:");
        
        while (true) {
            	serverSelector.select();
                Set<SelectionKey> set = serverSelector.selectedKeys();
                Iterator<SelectionKey> iterator = set.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    if (selectionKey.isAcceptable()) {
                    	SocketChannel socketChannel = (SocketChannel) (((ServerSocketChannel) selectionKey.channel()).accept());
                    	socketChannel.configureBlocking(false);
    					// 在这里可以给客户端发送信息
                    	socketChannel.write(ByteBuffer.wrap(new String("向客户端发送了一条信息").getBytes()));
    					// 在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
                    	socketChannel.register(serverSelector, SelectionKey.OP_READ);
                    } else if (selectionKey.isReadable()) {
                    	// 服务器可读取消息:得到事件发生的Socket通道
                		SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                		// 创建读取的缓冲区
                		ByteBuffer buffer = ByteBuffer.allocate(20);
                		socketChannel.read(buffer);
                		byte[] data = buffer.array();
                		String msg = new String(data).trim();
                		System.out.println("服务端收到信息：" + msg);
                		// 将消息回送给客户端
                		ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
                		socketChannel.write(outBuffer);
    				}

            }
        }
       
    }

}
