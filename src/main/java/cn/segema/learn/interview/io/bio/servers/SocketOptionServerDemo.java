package cn.segema.learn.interview.io.bio.servers;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

import cn.segema.learn.interview.io.bio.servers.HandlerServerDemo.HandlerServer;

public class SocketOptionServerDemo {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket();
			serverSocket.setReuseAddress(true);
			serverSocket.setSoTimeout(1000);
			SocketAddress address = new InetSocketAddress("127.0.0.1", 9999);
			serverSocket.bind(address);
			while (true) {
				try {
					Socket client = serverSocket.accept();
					System.out.println("receive client connect, localPort=" + client.getPort());
					new Thread(new Handler(client)).start();
				} catch (Exception e) {
					System.out.println("client exception,e=" + e.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Handler implements Runnable {

		private Socket client;

		public Handler(Socket client) {
			this.client = client;
		}

		public void run() {
			byte[] buf = new byte[1024];
			try {
				while (true) {
					int cnt = this.client.getInputStream().read(buf, 0, 1023);
					if (cnt > 0) {
						System.out.println("receive msg from client:" + new String(buf));
						this.client.getOutputStream().write(buf, 0, cnt);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (!this.client.isClosed()) {
					try {
						this.client.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
