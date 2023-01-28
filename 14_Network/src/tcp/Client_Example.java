package tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client_Example {
	public static void main(String[] args) {
		// Socket socket = new Socket("localhost", 5001);
		// Socket socket = new Socket(new InetSocketAddress("localhost", 5001);

		Socket socket = null; // 클라이언트에서 서버에 연결요청을 하기 위한 소켓 변수 선언
		System.out.println("[연결 요청]");
		try {
			socket = new Socket(); // 클라이언트에서 서버에 연결요청을 하기 위한 소켓 객체 생성
			socket.connect(new InetSocketAddress("localhost", 5001)); // 로컬호스트 아이피 5001 포트가 바인딩된 서버를
																		// 연결.
			System.out.println("[연결 성공]");
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
			}

		}
	}

}
