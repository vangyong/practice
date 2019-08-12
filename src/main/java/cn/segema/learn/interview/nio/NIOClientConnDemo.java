package cn.segema.learn.interview.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOClientConnDemo {
	public static void main(String[] args) throws IOException {
		// 对应IO编程中客户端启动
		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);
		Selector clientSelector =  Selector.open();
		channel.connect(new InetSocketAddress("localhost", 8000));
		channel.register(clientSelector, SelectionKey.OP_CONNECT);
		System.out.println("client started:");
		
		while (true) {
			clientSelector.select();
			Set<SelectionKey> set = clientSelector.selectedKeys();
			Iterator<SelectionKey> iterator = set.iterator();

			while (iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				iterator.remove();
				if (selectionKey.isConnectable()) {
					SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
					// 如果正在连接，则完成连接
					if (socketChannel.isConnectionPending()) {
						socketChannel.finishConnect();
					}
					// 设置成非阻塞
					socketChannel.configureBlocking(false);

					// 在这里可以给服务端发送信息
					socketChannel.write(ByteBuffer.wrap(new String("向服务端发送了一条信息").getBytes()));
					// 在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。
					channel.register(clientSelector, SelectionKey.OP_READ);

				}else if(selectionKey.isReadable()) {
					// 服务器可读取消息:得到事件发生的Socket通道
					SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
					ByteBuffer buffer = ByteBuffer.allocate(20);
					socketChannel.read(buffer);
					byte[] data = buffer.array();
					String msg = new String(data).trim();
					System.out.println("客户端收到信息：" + msg);
				}

			}
		}
	}

}
