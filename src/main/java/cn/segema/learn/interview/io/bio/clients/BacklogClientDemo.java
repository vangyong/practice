package cn.segema.learn.interview.io.bio.clients;

import java.net.Socket;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BacklogClientDemo {
	public static void main(String[] args) {
		int cnt = 0;
		List<Socket> sockets = new LinkedList<Socket>();
		while (cnt++ < 10) {
			try {
				Socket socket = new Socket("", 9999);
				System.out.println("connect server success, cnt=" + cnt);
				sockets.add(socket);
				socket.getOutputStream().write((new Date() + ": hello "+cnt+" 's message ").getBytes());
				socket.getOutputStream().flush();
			} catch (Exception e) {
				System.out.println("connect server fail, cnt=" + cnt);
				e.getMessage();
			}
		}

		for (Socket s : sockets) {
			try {
				if (s.isConnected()) {
					s.close();
				}
			} catch (Exception e) {
				e.getMessage();
			}

		}
	}
}
