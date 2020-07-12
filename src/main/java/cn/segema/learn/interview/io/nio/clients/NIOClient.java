package cn.segema.learn.interview.io.nio.clients;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOClient {
	// 通道管理器
	private Selector selector;

	/**
	 * 获得一个Socket通道，并对该通道做一些初始化的工作
	 * @param ip   连接的服务器的ip
	 * @param port 连接的服务器的端口号
	 */
	public void initClient(String ip, int port) throws IOException {
		// 获得一个Socket通道
		SocketChannel socketChannel = SocketChannel.open();
		// 设置通道为非阻塞
		socketChannel.configureBlocking(false);
		// 获得一个通道管理器
		this.selector = Selector.open();
		// 客户端连接服务器,其实方法执行并没有实现连接，需要在listen()方法中调
		// 用socketChannel.finishConnect();才能完成连接
		socketChannel.connect(new InetSocketAddress(ip, port));
		// 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件。
		socketChannel.register(selector, SelectionKey.OP_CONNECT);
	}

	/**
	 * 采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理
	 */
	public void listen() throws IOException {
		while (true) {
			selector.select();
			Iterator iterator = this.selector.selectedKeys().iterator();
			while (iterator.hasNext()) {
				SelectionKey selectionKey = (SelectionKey) iterator.next();
				// 删除已选的key,以防重复处理
				iterator.remove();
				if (selectionKey.isConnectable()) {
					SocketChannel channel = (SocketChannel) selectionKey.channel();
					// 如果正在连接，则完成连接
					if (channel.isConnectionPending()) {
						channel.finishConnect();
					}
					channel.configureBlocking(false);
					// 给服务端发送信息
					channel.write(ByteBuffer.wrap(new String("向服务端发送了一条信息").getBytes()));
					// 在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。
					channel.register(this.selector, SelectionKey.OP_READ);
				} else if (selectionKey.isReadable()) {
					read(selectionKey);
				}
			}
		}
	}

	/**
	 * 处理读取服务端发来的信息 的事件
	 * 
	 * @param selectionKey
	 * @throws IOException
	 */
	public void read(SelectionKey selectionKey) throws IOException {
		SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
		// 创建读取的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(20);
		socketChannel.read(buffer);
		byte[] data = buffer.array();
		String msg = new String(data).trim();
		System.out.println("客户端收到信息：" + msg);
		// 将消息回送给服务端
//		ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
//		channel.write(outBuffer);
	}

	/**
	 * 启动客户端测试
	 */
	public static void main(String[] args) throws IOException {
		NIOClient client = new NIOClient();
		client.initClient("localhost", 8000);
		client.listen();
	}

}
