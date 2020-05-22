package cn.segema.learn.interview.io.nio.servers;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import io.netty.handler.codec.FixedLengthFrameDecoder;

public class NIOServer {

	// 通道管理器
	private Selector selector;

	/**
	 * 获得一个ServerSocket通道，并对该通道做一些初始化的工作
	 * @param port 绑定的端口号
	 */
	public void initServer(int port) throws IOException {
		// 获得一个ServerSocket通道
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		// 设置通道为非阻塞
		serverSocketChannel.configureBlocking(false);
		// 将该通道对应的ServerSocket绑定到port端口
		serverSocketChannel.socket().bind(new InetSocketAddress(port));
		// 获得一个通道管理器
		this.selector = Selector.open();
		// 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后，
		// 当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
	}

	/**
	 * 采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理
	 */
	@SuppressWarnings("unchecked")
	public void listen() throws IOException {
		System.out.println("服务端启动成功！");
		// 轮询访问selector
		while (true) {
			// 当注册的事件到达时，方法返回；否则,该方法会一直阻塞
			selector.select();
			// 获得selector中选中的项的迭代器，选中的项为注册的事件
			Iterator iterator = this.selector.selectedKeys().iterator();
			while (iterator.hasNext()) {
				SelectionKey selectionKey = (SelectionKey) iterator.next();
				// 删除已选的key,以防重复处理
				iterator.remove();
				// 客户端请求连接事件
				if (selectionKey.isAcceptable()) {
					ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
					SocketChannel socketChannel = serverSocketChannel.accept();
					socketChannel.configureBlocking(false);
					socketChannel.write(ByteBuffer.wrap(new String("向客户端发送了一条信息").getBytes()));
					
					// 在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
					socketChannel.register(this.selector, SelectionKey.OP_READ);
				} else if (selectionKey.isReadable()) {
					read(selectionKey);
				}
			}
		}
	}

	/**
	 * 处理读取客户端发来的信息的事件
	 * @param selecttionKey
	 */
	public void read(SelectionKey selecttionKey) throws IOException {
		SocketChannel socketChannel = (SocketChannel) selecttionKey.channel();
		ByteBuffer buffer = ByteBuffer.allocate(20);
		socketChannel.read(buffer);
		byte[] data = buffer.array();
		String msg = new String(data).trim();
		System.out.println("服务端收到信息：" + msg);
		// 将消息回送给客户端
		ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
		socketChannel.write(outBuffer);
	}

	/**
	 * 启动服务端测试
	 */
	public static void main(String[] args) throws IOException {
		NIOServer server = new NIOServer();
		server.initServer(8000);
		server.listen();
	}
}
