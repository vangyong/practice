package cn.segema.learn.interview.io.bio.servers;

import java.net.ServerSocket;
import java.net.Socket;

public class BacklogServerDemo {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(9999, 2);
			System.out.println("server listen on port:" + 9999);
			System.out.println("main thread:" + Thread.currentThread().getName());
			Thread.sleep(20000);
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
			System.out.println("server exception,e=" + e.getMessage());
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
						System.out.println("current thread name:" +Thread.currentThread().getName());
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
